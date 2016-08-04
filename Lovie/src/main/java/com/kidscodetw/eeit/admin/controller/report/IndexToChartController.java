package com.kidscodetw.eeit.admin.controller.report;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexToChartController {
	
	@RequestMapping("admin/index")
	public String indexToChart(){
		return "/admin/report/chart.jsp";
	}
	
}
