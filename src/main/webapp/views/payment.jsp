<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
<link href="<%=request.getContextPath()%>/css/style.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid mb-5">
		<form action="/payment" method="post">
			<div class="col-sm-6 mb-5">
				<div class="card">
					<div class="card-body">
					<h3>Thanh toán</h3>
						<div class="form-group">
							<label>Nhập địa chỉ: </label>
							<input type="text" name="address"
								class="form-control" required >
						</div>
						<div>
							<table class="table">
								<thead>
									<tr>
										<th>Product</th>
										<th>Price</th>
										<th>Quantity</th>
									</tr>
								</thead>
								<c:forEach var="item" items="${cart.orderDetails}">
									<tr>
										<td>${item.product.name}</td>
										<fmt:formatNumber type="number" pattern="###,###,### VNĐ"
											value="${item.product.price}" var="price" />
										<td>${price}</td>
										<td>${item.quantity}</td>
									</tr>
								</c:forEach>
								<tfoot>
								<fmt:formatNumber type="number" pattern="###,###,### VNĐ"
											value="${total}" var="totalMoney" />
									<tr>
										<td colspan="3"><h6>Tổng tiền: <span>${totalMoney}</span></h6></td>
									</tr>
								</tfoot>
							</table>

						</div>
						<button type="submit" class="btn btn-primary mt-3">Thanh toán</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery/dist/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>