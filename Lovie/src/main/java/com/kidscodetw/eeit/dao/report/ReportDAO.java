package com.kidscodetw.eeit.dao.report;

import java.sql.Timestamp;
import java.util.List;

import com.kidscodetw.eeit.entity.report.ReportBean;

public interface ReportDAO {
	public abstract List<ReportBean> report1select(Integer p_privilege, Byte p_gender, Timestamp p_lastOnTime);
}