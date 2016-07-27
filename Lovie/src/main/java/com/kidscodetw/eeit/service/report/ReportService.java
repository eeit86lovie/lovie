package com.kidscodetw.eeit.service.report;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.kidscodetw.eeit.dao.report.ReportDAO;
import com.kidscodetw.eeit.entity.report.ReportBean;

public class ReportService {
	
	private ReportDAO reportDAO;
	public ReportService(ReportDAO reportDAO){
		this.reportDAO = reportDAO;
	}
	
	public List<ReportBean> report1select(Integer p_privilege, Byte p_gender,Timestamp p_lastOnTime) {
		List<ReportBean> result = null;
		result = reportDAO.report1select(p_privilege, p_gender, p_lastOnTime);
		return result;
	}

}
