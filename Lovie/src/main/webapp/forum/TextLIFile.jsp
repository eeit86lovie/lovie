<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

.container:active .selector { 
    display:block;
	 
    } 

.title { 
    width:100px;
	height:30px;
	background-color:#CCC;
	font-size:18px;
	line-height:30px;
	text-align:center;
	 
    } 

.selector { 
    display:none; 
    position:absolute;
	padding-top:24px; 
    } 
 
.selector:hover { 
	display:block;
    } 

.selector span { 
    display:block;
	width:100px;
	height:30px;
	background-color:#CCC;
	font-size:18px;
	line-height:30px;
	text-align:center; 
    }
</style>

</head>
<body>

<div class="container"> 

    <div class="selector"> 

        <span>選項</span> 
        <span>其他</span> 
    </div> 
 
    <div class="title">按鈕</div> 

</div>


</body>
</html>