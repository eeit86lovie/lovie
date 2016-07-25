package com.kidscodetw.eeit.service.report;

import java.util.List;

import com.kidscodetw.eeit.dao.report.ChartDAO;
import com.kidscodetw.eeit.entity.report.Chart1Bean;
import com.kidscodetw.eeit.entity.report.Chart2Bean;
import com.kidscodetw.eeit.entity.report.Chart3Bean;

public class ChartService {
	
	private ChartDAO chartDAO;
	public ChartService(ChartDAO chartDAO){
		this.chartDAO = chartDAO;
	}
	
	public List<Chart1Bean> chart1select(){
		List<Chart1Bean> result = null;
		result = chartDAO.chart1select();
		return result;
	}
	public List<Chart2Bean> chart2select(){
		List<Chart2Bean> result = null;
		result = chartDAO.chart2select();
		return result;
	}
	public List<Chart3Bean> chart3select(){
		List<Chart3Bean> result = null;
		result = chartDAO.chart3select();
		return result;
	}

}
