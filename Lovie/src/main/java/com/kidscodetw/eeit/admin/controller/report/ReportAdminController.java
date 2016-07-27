package com.kidscodetw.eeit.admin.controller.report;

import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kidscodetw.eeit.entity.report.Chart1Bean;
import com.kidscodetw.eeit.entity.report.ReportBean;
import com.kidscodetw.eeit.entity.report.ReportBean2;
import com.kidscodetw.eeit.service.report.ReportService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
@RequestMapping("/admin/report")
public class ReportAdminController {
	@Autowired
	ReportService reportService ;

    private String DOWNLOAD_FILE_NAME = "REPORT.pdf";
    private String FILE_TYPE = "application/pdf";
    
	@RequestMapping("/reportMemberDetail")
	private void generateReport(
			@RequestParam("privilege") Integer p_privilege,
			@RequestParam("gender") Byte p_gender,
			@RequestParam("lastOnTime") String t_lastOnTime,
			  HttpServletRequest request,
		      HttpServletResponse response) {
		
		response.setContentType("text/html;charset=UTF-8");
		List<ReportBean> dataList;
		String reportPath;
		OutputStream outStream;
		JasperReport jasperReport;
		JasperDesign jasperDesign;
		JRDataSource reportSource = null;
		Map reportParameters;
		try {
		  reportPath = request.getServletContext().
		      getRealPath("/admin/report") + "/report.jrxml";
		
		  //Set report parameters
		  StringBuffer p_select = new StringBuffer();
		  if (p_privilege == 1)
		  {   if (p_select.length()>0) 
			  	 p_select.append(",");
			  p_select.append("一般會員");
		  }
		  if (p_privilege == 2)
		  {   if (p_select.length()>0) 
			  	 p_select.append(",");
			  p_select.append("黃金會員");
		  }
		  if (p_privilege == 3)
		  {   if (p_select.length()>0) 
			  	 p_select.append(",");
			  p_select.append("管理員");
		  }
		  if (p_gender == 0)
		  {   if (p_select.length()>0) 
			  	 p_select.append(",");
			  p_select.append("女會員");
		  }
		  if (p_gender == 1)
		  {   if (p_select.length()>0) 
			  	 p_select.append(",");
			  p_select.append("男會員");
		  }
		  //Byte p_gender =1;
		  Timestamp p_lastOnTime = null;
		  if (t_lastOnTime != null && t_lastOnTime.trim().length()> 0)
		  {
			  p_lastOnTime =Timestamp.valueOf(t_lastOnTime+" 00:00:00");
			  if (p_select.length()>0) 
				  p_select.append(",");
			  p_select.append("最後登入日在 "+t_lastOnTime+" 之前");
		  }
		  
		  //對應jrxml,要放入 <parameter name="p_select" class="java.lang.String"/>
		  reportParameters = new HashMap();
		  if (p_select.length()>0) 
			  reportParameters.put("p_select", new String("查詢條件："+p_select));
		  else
			  reportParameters.put("p_select", "");
		  
		  // Compile Jasper Report.
		  jasperDesign = JRXmlLoader.load(reportPath);
		  jasperReport = JasperCompileManager.compileReport(jasperDesign);
		  //* Get report DataSource.
		  dataList = reportService.report1select(p_privilege, p_gender, p_lastOnTime);
	  	  if (dataList == null) {
   		    System.out.println("查無相符資料,請重新輸入查詢條件 <br />");
		  } else {
	  		int count = 0;
	  		List<ReportBean2> dataList2 = new ArrayList<ReportBean2>();
	  		for (ReportBean bean : dataList) {
	  			ReportBean2 bean2 = new ReportBean2();
	  			bean2.setId(bean.getId());
	  			bean2.setAccount(bean.getAccount());
	  			if (bean.getGender() == 0)
	  			   bean2.setGender(false);		  
	  			else
	  			   bean2.setGender(true);		  
	  			bean2.setEmail(bean.getEmail());		  			
	  			bean2.setNickname(bean.getNickname());
	  			bean2.setPrivilege(bean.getPrivilege());
	  			bean2.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(bean.getBirthday()));
	  			bean2.setRegisteredTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(bean.getRegisteredTime()));
	  			bean2.setLastOnTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(bean.getLastOnTime()));
	  			dataList2.add(bean2); 
		  			count++;
		  		}
		  		//System.out.println("reportMemberDetail,共有" + count+"筆資料<br />");
		        reportSource = new JRBeanCollectionDataSource(dataList2);
		  	}

		  	// * Get byteStream for generated Stream.
		  	byte[] byteStream;
		    byteStream = JasperRunManager.runReportToPdf(jasperReport,
		          reportParameters, reportSource);

		    //* Set output Stream in response.
		      outStream = response.getOutputStream();
		      response.setHeader("Content-Disposition", "inline; filename=\"" + DOWNLOAD_FILE_NAME+"\"");
		      response.setContentType(FILE_TYPE);
		      response.setContentLength(byteStream.length);
		      outStream.write(byteStream, 0, byteStream.length);
		} catch (JRException ex) {
		     Logger.getLogger("ReportAdminController.java").log(Level.SEVERE, null, ex);
		} catch (Exception e) {
		      e.printStackTrace();
		}
	}
}
