<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="<%=request.getContextPath()%>/css/style.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<h1 class="my-4">Shop</h1>
				<div class="list-group w3-light-grey">
					<a href="/"
						class="list-group-item list-group-item-action">Tất cả</a>
					<c:forEach var="category" items="${category}">
						<a href="/category/${category.id}"
							class="list-group-item list-group-item-action">${category.name}</a>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-9">
				<div class="row">
					<c:forEach var="product" items="${product}">
						<div class="col-lg-3 col-md-4 mb-4">
							<div class="card h-100">
								<a> <img class="card-img-top"
									src="/images/product/${product.image}">
								</a>
								<div class="card-body">
									<h4 class="card-title">
										<a>${product.name}</a>
									</h4>
									<fmt:formatNumber type="number" pattern="###,###,### VNĐ"
										value="${product.price}" var="price" />
									<h5>${price}</h5>
								</div>
								<div class="card-footer">
									<form action="/cart/buy/${product.id}" method="post" class="m-0 p-0">
										<button class="float-right btn m-0 p-0" type="submit">
											<i class="fa fa-cart-plus fa-2x text-success"></i>Add to Cart
										</button>
									</form>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery/dist/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</body>
</html>