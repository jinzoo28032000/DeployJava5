<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand mr-1" href="/">Online Shopping</a>
			<form action=""
				class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
				<div class="input-group">
					<input type="text" name="searchWord" class="form-control"
						placeholder="Search for..." aria-label="Search"
						aria-describedby="basic-addon2">
					<div class="input-group-append">
						<button class="btn btn-primary" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>
			<ul class="navbar-nav ml-auto ml-md-0 me-5">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDarkDropdownMenuLink" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> <i
						class="fa fa-2x text-light fa fa-shopping-cart fa-fw"></i><span
						class="badge badge-danger m-0">${quantity}</span>
				</a>
					<ul class="dropdown-menu dropdown-menu-light"
						aria-labelledby="navbarDarkDropdownMenuLink">
						<table class="table mb-0 mt-0 table-hover">
							<tfoot>
								<tr>
									<td class="text-right" colspan="2"><a href="/cart">View
											Shopping Cart</a></td>
								</tr>
							</tfoot>
							<tbody>
								<c:if test="${cart != null}">
									<c:forEach var="item" items="${cart.orderDetails}">
										<tr>
											<td><span class=""><img
													src="/images/product/${item.product.image}" alt="user"
													width="50" /></span></td>
											<td class="align-middle">${item.product.name}</td>
											<fmt:formatNumber type="number" pattern="###,###,### VNĐ"
												value="${item.product.price}" var="price" />
											<td>${price}</td>
											<td>${item.quantity}</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</ul></li>
				<li class="nav-item dropdown no-arrow mx-1"><a
					class="nav-link dropdown-toggle" href="#" id="messageDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i
						class="fa fa-bell fa-2x text-light fa-fw"></i> <span
						class="badge badge-danger m-0" id="user-message-count"></span>
				</a>
					<div class="dropdown-menu dropdown-menu-right shadow pb-0"
						style="min-width: 350px" aria-labelledby="messageDropdown">
						<div class="card-body pl-3 pr-3 pt-2 pb-0">
							<div id="user-messages"></div>
						</div>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDarkDropdownMenuLink" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> <i
						class="fa fa-2x text-light fa-user-circle fa-fw"></i>
				</a>
					<ul class="dropdown-menu dropdown-menu-dark"
						aria-labelledby="navbarDarkDropdownMenuLink">
						<c:if test="${userInfo == null}">
							<li><a class="dropdown-item" href="/login">Login</a></li>
						</c:if>
						<c:if test="${userInfo != null}">
							<div class="dropdown-item">
								<div class="font-weight-bold">${userInfo.fullname}</div>
								<div class="text-muted">${userInfo.email}</div>
							</div>
							<li><a class="dropdown-item" href="/logout">Logout</a></li>
						</c:if>
					</ul></li>
			</ul>
		</div>
	</nav>
</body>
</html>