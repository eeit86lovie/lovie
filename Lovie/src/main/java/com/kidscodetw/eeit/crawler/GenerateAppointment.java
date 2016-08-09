package com.kidscodetw.eeit.crawler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;
import com.kidscodetw.eeit.jdbc.ShowtimeDAOJdbc;
import com.kidscodetw.eeit.util.CommonUtil;

public class GenerateAppointment{
	
	
	public static void main(String[] args){
		//生成女生約會(10份)
		new GenerateAppointment().generateGirlAppointment(10);
		//生成男生約會(10份)
		new GenerateAppointment().generateBoyAppointment(10);
	}
	
	
	
	public void generateGirlAppointment(int times){
		PopulateData p = new PopulateData();
		GenerateAppointment ga = new GenerateAppointment();
		for(int i=0; i<times; i++){
			MemberBean girl = p.getOneGirl();
			ga.generateProgressAppointment(girl.getId(), p.getOneShowtime().getId(), 
				"大家好，我是"+girl.getNickname()+"，星座是"+girl.getConstellation()+"，目前住在"+girl.getCity()+"，歡迎找我看電影。");
		}
	}
	
	public void generateBoyAppointment(int times){
		PopulateData p = new PopulateData();
		GenerateAppointment ga = new GenerateAppointment();
		for(int i=0; i<times; i++){
			MemberBean girl = p.getOneBoy();
			ga.generateProgressAppointment(girl.getId(), p.getOneShowtime().getId(), 
				"大家好，我是"+girl.getNickname()+"，星座是"+girl.getConstellation()+"，目前住在"+girl.getCity()+"，歡迎找我看電影。");
		}
	}
	
	
	public void generateProgressAppointment(int memberId, int showtimeId, String content){
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			 pstat = conn.prepareStatement("Insert into Appointment "+
					"(memberId, showtimeId, content) VALUES (?,?,?)");
			 pstat.setInt(1, memberId);
			 pstat.setInt(2, showtimeId);
			 pstat.setString(3, content);
			 pstat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstat!=null){
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}

class PopulateData{
	
	private static List<MemberBean> allMembers = new ArrayList<MemberBean>();
	private static List<MemberBean> allGirls = new ArrayList<MemberBean>();
	private static List<MemberBean> allBoys = new ArrayList<MemberBean>();
	private static List<ShowtimeBean> allShowtimes = new ArrayList<ShowtimeBean>();

	public PopulateData(){
		if(allMembers.isEmpty()){
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
			MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
			allMembers = memberDAO.select();
			for(MemberBean bean :allMembers){
				if(bean.getGender()==0){
					allGirls.add(bean);
				}else if(bean.getGender()==1){
					allBoys.add(bean);
				}
			}
			
		}
		
		if(allShowtimes.isEmpty()){
			ShowtimeDAOJdbc showtimeDAO = new ShowtimeDAOJdbc();
			allShowtimes = showtimeDAO.select();
		}
	}
	
	public List<MemberBean> getAllMembers(){
		return allMembers;
	}
	
	public List<MemberBean> getAllGirls(){
		return allGirls;
	}
	
	public List<MemberBean> getAllBoys(){
		return allBoys;
	}
	
	public List<ShowtimeBean> getAllShowtimes(){
		return allShowtimes;
	}
	
	public MemberBean getOneGirl(){
		List<MemberBean> girls = getAllGirls();
		Random random = new Random();
		int seq = random.nextInt(girls.size()) + 1;
		return girls.get(seq);
	}
	
	public MemberBean getOneBoy(){
		List<MemberBean> boys = getAllBoys();
		Random random = new Random();
		int seq = random.nextInt(boys.size()) + 1;
		return boys.get(seq);
	}
	
	public ShowtimeBean getOneShowtime(){
		List<ShowtimeBean> showtimes = getAllShowtimes();
		Random random = new Random();
		int seq = random.nextInt(showtimes.size()) + 1;
		return showtimes.get(seq);
	}
	
	
}
