package com.kidscodetw.eeit.controller.member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/secure/MemberListSevlet.do")
public class MemberListSevlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private MemberGetListService memberGetListService;
//
//	@Override
//	public void init() throws ServletException {
//		ApplicationContext context = WebApplicationContextUtils
//				.getWebApplicationContext(this.getServletContext());
//		this.memberGetListService = (MemberGetListService) context
//				.getBean("memberGetListService");
//	}
//
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		List<MemberBean> memberBean = null;
//		String gender = request.getParameter("gender");
//		System.out.println();
//		if (gender.equals("0")) {
//			memberBean = memberGetListService.getAllGirls();
//		} else if (gender.equals("1")) {
//			memberBean = memberGetListService.getAllBoys();
//		}
//		for (MemberBean mb : memberBean) {
//			if(mb.getBirthday().length()>4){
//			int intValue = Integer.parseInt(mb.getBirthday()
//					.substring(0, 4));
//			Date today = Calendar.getInstance().getTime();
//			int age = today.getYear() + 1900 - intValue;
//			mb.setBirthday(age + "");}
//		}
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		Gson gson = new Gson();
//		String BeanList = gson.toJson(memberBean);
//		out.write(BeanList);
//
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
