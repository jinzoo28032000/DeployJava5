<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link href="<%=request.getContextPath()%>/css/style.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<h1>Shopping Cart</h1>
		<div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Sản phẩm</th>
								<th>Đơn giá</th>
								<th>Số lượng</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${cart.orderDetails}">
								<tr>
									<td>${item.product.name}</td>
									<fmt:formatNumber type="number" pattern="###,###,### VNĐ"
										value="${item.product.price}" var="price" />
									<td>${price}</td>
									<td>${item.quantity}</td>
									<td><a href="/cart/remove/${item.product.id}"><button class="btn btn-danger">Remove</button></a></td>		
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<a href="/cart/purchase"><button class="btn btn-success">Mua hàng</button></a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>