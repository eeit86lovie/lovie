<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<style type="text/css">
td{
	min-width: 10px;
	overflow: hidden;
}

</style>
</head>
<body>
	<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-4">
					<h2 class="">訂單管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
			
			</div>
			<hr>
			<div class="row">
				<table class="table">
				<c:forEach items="${memberIds}" var="memberId">
				<th>交易時間</th>
						<th>帳號</th>
						<th>收件人</th>
						<th>電話</th>
						<th>地址</th>
						<th>購買產品</th>
						<th>購買數量</th>
						<th>金額</th>
						<tr />
					<c:forEach items="${checkoutItems[memberId]}" var="checkoutItem" varStatus="vs">
						
						<c:choose>
							<c:when test="${checkoutItem.checktradeTime != tradeT}">
								<td>${checkoutItem.checktradeTime }</td>
							</c:when>
							<c:when test="${checkoutItem.checktradeTime == tradeT}">
								<td></td>
							</c:when>
						</c:choose>
						<td>${checkoutItem.memberid }</td>
						<td>${checkoutItem.memberaccount }</td>
						<td>${checkoutItem.memberphone }</td>
						<td>${checkoutItem.memberaddress }</td>
						<td>${checkoutItem.productname }</td>
						<td>${checkoutItem.amount }</td>
						<td>${checkoutItem.totalcost }</td>	
						<tr />
						<c:set var="tradeT" value="${checkoutItem.checktradeTime }"></c:set>
					</c:forEach>
				</c:forEach>
				</table>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
			<script>
			
				
			
			</script>
</body>
</html>
