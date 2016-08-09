<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>標題</title>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
	
	<div class="container">

<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formBackstage.css" />

<div class="container">
    <div class="row">


        <div class="col-md-10 col-md-offset-1">

            <div class="panel panel-default panel-table">

              <div class="panel-body">
                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>                       
                        <th>問題種類</th>
                        <th class="hidden-xs">編號</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>問題內容</th>
                        <th>控制</th>
                    </tr> 
                  </thead>
                  <tbody>
                          <tr>
                            <td>帳號</td>
                            <td class="hidden-xs">3122094</td>
                            <td>溫雅</td>
                            <td>AA@BB.CC</td>
                            <td>我的帳號登入不了是怎麼了?</td>
                            <td align="center">
                              <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                              <a class="btn btn-danger"><em class="fa fa-trash"></em></a>                                                           
                            </td>
                          </tr>
                        </tbody>
                </table>
            
              </div>
            </div>

</div></div></div>
		
		
		</div>
		
	
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>