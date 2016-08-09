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
                        <th>Photo</th>
                        <th>問題內容</th>
                        <th>控制</th>
                    </tr> 
                  </thead>
                  <tbody>
                          <tr>

                            <td>問題</td>
                            <td class="hidden-xs">1</td>
                            <td>John Doe</td>
                            <td>johndoe@example.com</td>
                            <td>相片</td>
                            <td>內容</td>
                            <td align="center">
                              <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                              <a class="btn btn-danger"><em class="fa fa-trash"></em></a>                                                           
                            </td>
                          </tr>
                        </tbody>
                </table>
            
              </div>
              <div class="panel-footer">
                <div class="row">
                  <div class="col col-xs-4">Page 1 of 5
                  </div>
                  <div class="col col-xs-8">
                    <ul class="pagination hidden-xs pull-right">
                      <li><a href="#">1</a></li>
                      <li><a href="#">2</a></li>
                      <li><a href="#">3</a></li>
                      <li><a href="#">4</a></li>
                      <li><a href="#">5</a></li>
                    </ul>
                    <ul class="pagination visible-xs pull-right">
                        <li><a href="#">«</a></li>
                        <li><a href="#">»</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>

</div></div></div>
		
		
		</div>
		
	
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>