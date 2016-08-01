<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

ul { 
	list-style-type:none;
	width:50px;
	height:30px;
	background-color:#C63300;
	font-size:18px;
	line-height:30px;
	text-align:center;
	position:relative;
	top:20px;
	left:50px; 
    } 
li{
	list-style-type:none;
	width:50px;
	height:30px;
	background-color:#CCC;
}
.aa { 
    display:none; 
    position:absolute;
	padding-top:24px; 
    } 
 
.aa:hover { 
	display:block;
    } 
ul:active .aa { 
    display:block;
	width:50px;
	height:30px;
	font-size:18px;
	text-align:center; 
    }
</style>

</head>
<body>

<ul>按鈕
       <li class="aa">選項</li> 
       <li class="aa">其他</li> 
</ul>


</body>
</html>