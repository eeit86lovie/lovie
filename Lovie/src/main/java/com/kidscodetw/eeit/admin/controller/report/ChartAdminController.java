package com.kidscodetw.eeit.admin.controller.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.entity.report.Chart1Bean;
import com.kidscodetw.eeit.entity.report.Chart2Bean;
import com.kidscodetw.eeit.entity.report.Chart3Bean;
import com.kidscodetw.eeit.service.report.ChartService;

@Controller
@RequestMapping("/admin/report")
public class ChartAdminController {
	@Autowired
	ChartService chartService;
	
	@RequestMapping("/chart1select")
	public @ResponseBody List<Chart1Bean> select1json() {
		List<Chart1Bean> list = chartService.chart1select();
		return list;
	}

	@RequestMapping("/chart2select")
	public @ResponseBody List<Chart2Bean> select2json() {
		List<Chart2Bean> list = chartService.chart2select();
		return list;
	}

	@RequestMapping("/chart3select")
	public @ResponseBody List<Chart3Bean> select3json() {
		List<Chart3Bean> list = chartService.chart3select();
		return list;
	}
	
}
