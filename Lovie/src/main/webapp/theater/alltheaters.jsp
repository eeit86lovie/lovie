<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>戲院列表</title>

<style type="text/css">
.theater-item {
	margin: 10px;
}

.col-md-4{
	margin-bottom: 10px;
}

.citysubmenu{
	text-align: center;
	margin-bottom: 2px;
	cursor:pointer;
}

.dropdown-menu{
	min-width:100px;
}
</style>

</head>
<body>
	<c:import url="/header.jsp"></c:import>

	<div class="container">
	${pageContext.session.id}
	
<sec:authorize access="hasRole('ADMIN')">
	<div style="color:red">ADMIN測試</div>: 
</sec:authorize>

<sec:authorize access="hasRole('GOLD') and !hasRole('ADMIN')">
	<div style="color:red">黃金會員測試</div>: 
</sec:authorize>

<sec:authorize access="hasRole('USER') and !hasRole('GOLD') and !hasRole('ADMIN')">
	<div style="color:red">一般會員測試</div>: 
</sec:authorize>
		<div class="row" style="margin-bottom: 20px;">
			<div class="col-md-12">
				<div class="city col-md-3" style="float: left; margin-right: 20px">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="buttonCity" data-toggle="dropdown">
						&nbsp;&nbsp;城市&nbsp;&nbsp; <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" id="menuCity" aria-labelledby="menuCity">
					</ul>
				</div>

			</div>
		</div>
		<div class="row">
			<div id="theater_item">
				<div id="theater_list">
					
				</div>
			</div>
		</div>
	</div>


	<script>
	var city_data=[<c:forEach var="city" items="${citys}">"${city}",</c:forEach>]
	
	
		window.onload = function() {
			<c:forEach var="city" items="${citys}" varStatus="vs">
			var opt_li = document.createElement("li");
			var opt_a = document.createElement("div");
			opt_a.setAttribute("class", "citysubmenu")
			opt_a.setAttribute("id", "city${vs.count}");
			opt_a.setAttribute("onclick", "getcity(this)");
			var opt_text = document.createTextNode("${city}");
			opt_a.appendChild(opt_text);
			opt_li.appendChild(opt_a);
			var menuCity = document.getElementById("menuCity");
			menuCity.appendChild(opt_li);
			</c:forEach>

			<c:forEach var="theater" items="${theaters}" varStatus="vs">
			var t_row = document.createElement("div");
			t_row.setAttribute("class", "row")
			var t_col_md_4_1 = document.createElement("div");
			t_col_md_4_1.setAttribute("class", "col-md-4")
			var t_h1 = document.createElement("h1");
			t_h1.setAttribute("style", "font-size: 24px;")
			var t_a = document.createElement("a");
			t_a.setAttribute("href", "theater/${theater.id}")
			var t_text = document.createTextNode("${theater.name}");
			t_a.appendChild(t_text);
			t_h1.appendChild(t_a);
			t_col_md_4_1.appendChild(t_h1);
			
			var t_col_md_4_2 = document.createElement("div");
			t_col_md_4_2.setAttribute("class", "col-md-4")
			var t_text_2 = document.createTextNode("${theater.address }");
			var t_text_22 = document.createTextNode("${theater.phone }");
			t_col_md_4_2.appendChild(t_text_2);
			t_col_md_4_2.appendChild(document.createElement("br"));
			t_col_md_4_2.appendChild(t_text_22);
			t_col_md_4_2.appendChild(document.createElement("br"));
			
			var t_col_md_4_3 = document.createElement("div");
			t_col_md_4_3.setAttribute("class", "col-md-4")
			var t_a_3 = document.createElement("a");
			t_a_3.setAttribute("href", "${theater.websiteUrl}")
			var t_text_3 = document.createTextNode("網站");
			t_a_3.appendChild(t_text_3);
			t_col_md_4_3.appendChild(t_a_3);
			
			t_row.appendChild(t_col_md_4_1);
			t_row.appendChild(t_col_md_4_2);
			t_row.appendChild(t_col_md_4_3);
			var theater_list = document.getElementById("theater_list");
			theater_list.appendChild(t_row);
			</c:forEach>
			
		};
		
		function getcity(selected){
			
			var city_id_row = selected.getAttribute("id");
			var city_id = city_id_row.substring(4,city_id_row.length);
			var city_name = city_data[city_id-1];
			var theater_item = document.getElementById("theater_item");
			while (theater_item.firstChild) {
				theater_item.removeChild(theater_item.firstChild);
			};
			var theater_list = document.createElement("div");
			theater_list.setAttribute("id", "theater_list");
			theater_item.appendChild(theater_list);
			<c:forEach var="theater" items="${theaters}">
			if(city_name == "${theater.city}"){
				var t_row = document.createElement("div");
				t_row.setAttribute("class", "row")
				var t_col_md_4_1 = document.createElement("div");
				t_col_md_4_1.setAttribute("class", "col-md-4")
				var t_h1 = document.createElement("h1");
				t_h1.setAttribute("style", "font-size: 24px;")
				var t_a = document.createElement("a");
				t_a.setAttribute("href", "theater/${theater.id}")
				var t_text = document.createTextNode("${theater.name}");
				t_a.appendChild(t_text);
				t_h1.appendChild(t_a);
				t_col_md_4_1.appendChild(t_h1);
				
				var t_col_md_4_2 = document.createElement("div");
				t_col_md_4_2.setAttribute("class", "col-md-4")
				var t_text_2 = document.createTextNode("${theater.address }");
				var t_text_22 = document.createTextNode("${theater.phone }");
				t_col_md_4_2.appendChild(t_text_2);
				t_col_md_4_2.appendChild(document.createElement("br"));
				t_col_md_4_2.appendChild(t_text_22);
				t_col_md_4_2.appendChild(document.createElement("br"));
				
				var t_col_md_4_3 = document.createElement("div");
				t_col_md_4_3.setAttribute("class", "col-md-4")
				var t_a_3 = document.createElement("a");
				t_a_3.setAttribute("href", "${theater.websiteUrl }")
				var t_text_3 = document.createTextNode("網站");
				t_a_3.appendChild(t_text_3);
				t_col_md_4_3.appendChild(t_a_3);
				
				t_row.appendChild(t_col_md_4_1);
				t_row.appendChild(t_col_md_4_2);
				t_row.appendChild(t_col_md_4_3);
				var theater_list = document.getElementById("theater_list");
				theater_list.appendChild(t_row);
				
			}
			</c:forEach>
			
			
			
			
		}
		
	</script>


	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>