<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<style>
        ::-webkit-scrollbar {
            width: 0px;
        }
</style>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>會員列表</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
        <script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
		
	<div class="container">
	<!-- 程式碼位置 利用<div col-md-12> 編排 -->

		

					<ul id="memberTable" class="grid effect-6">
					</ul>
	
	
	
		
	</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script>
	
	
	var memberGender="${member.gender}"
	var genderNum=null;
	window.onload=function() {
				var tb = $("#memberTable")
				tb.empty()

				if(memberGender=="0"){
					genderNum="1";
				}else if(memberGender=="1"){
					genderNum="0";
				}else{var cell1  = $("<div></div>").append("請登入帳號方可觀看此頁") 
					tb.append(cell1)}
		$.ajax({
		"type":"get",
		"url":"${pageContext.request.contextPath}/secure/MemberListServlet/${member.gender}",
		"dataType" : "json",
		"success":function(memberBean){
			var flag = $(document.createDocumentFragment());
			$.each(memberBean,function(idx,member){	
				var img=$('<img />')
				img.addClass("img1");
 				img.attr('src',"photo/member/"+member.id)
 				var cell1=$("<a herf></a>")
 				cell1.attr('href',"${pageContext.request.contextPath}/member/profile/"+member.id)
				cell1.append(img)
// 				var cell1  = $("<div></div>").append(img)
				var cell2  = $("<div></div>").text(member.nickname)
				var cell3  = $("<div></div>").text(member.city)
				var cell4  = $("<div></div>").text(member.age+"歲")

				var row = $("<li class='item'></li>").append([cell1,cell2,cell3,cell4])
				flag.append(row);
			})
			tb.append(flag)
			
			new AnimOnScroll(document.getElementById('memberTable'), {
				minDuration : 0.4,
				maxDuration : 0.6,
				viewportFactor : 0.2
			});
			
		}
		})

			}

	</script>

	<script src="${pageContext.request.contextPath}/js/masonry.pkgd.mis.js"></script>
    <script src="${pageContext.request.contextPath}/js/classie.js"></script>
    <script src="${pageContext.request.contextPath}/js/imagesloaded.js"></script>
    <script src="${pageContext.request.contextPath}/js/AnimOnScroll.js"></script>	



</body>
</html>