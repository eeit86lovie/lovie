package com.kidscodetw.eeit.dao.report;

import java.util.List;

import com.kidscodetw.eeit.entity.report.Chart1Bean;
import com.kidscodetw.eeit.entity.report.Chart2Bean;
import com.kidscodetw.eeit.entity.report.Chart3Bean;

public interface ChartDAO {

	public abstract List<Chart1Bean> chart1select();

	public abstract List<Chart2Bean> chart2select();

	public abstract List<Chart3Bean> chart3select();
}