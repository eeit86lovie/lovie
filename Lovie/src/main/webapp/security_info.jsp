<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

後端程式:
try{
	SecurityContextImple SecurityContext = (SecurityContextImple) SecurityContextHolder.getContext();
	MemberBean bean = SecurityContext.getMemberBean();
	model.addAttribute("member",bean);
}catch(java.lang.ClassCastException e){}

${member.gender}
前端程式:

加入taglib宣告
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ADMIN')">
	<div style="color:red">ADMIN測試</div>: ${member}
</sec:authorize>

<sec:authorize access="hasRole('GOLD') and !hasRole('ADMIN')">
	<div style="color:red">黃金會員測試</div>: ${member}
</sec:authorize>

<sec:authorize access="hasRole('USER') and !hasRole('GOLD') and !hasRole('ADMIN')">
	<div style="color:red">一般會員測試</div>: ${member}
</sec:authorize>


</body>
</html>