<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link href="<%=request.getContextPath()%>/css/style.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<%@include file="../header.jsp"%>
		<%@include file="../menu.jsp"%>
		<div class="page-wrapper">
			<div class="page-breadcrumb">
				<div class="row align-items-center">
					<div class="col-md-6 col-8 align-self-center">
						<h3 class="page-title mb-0 p-0">Sản phẩm</h3>
						<div class="d-flex align-items-center">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="<%=request.getContextPath()%>/admin">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">
										HOA DON</li>
								</ol>
							</nav>
						</div>
					</div>
					<div class="col-md-6 col-4 align-self-center">
					</div>
				</div>
			</div>
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">
								<div class="table-responsive">
									<table class="table stylish-table no-wrap">
										<thead>
											<tr>
												<th class="border-top-0" colspan="1">Địa chỉ</th>
												<th class="border-top-0">Ngày mua</th>
												<th class="border-top-0">Người mua</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${list}">
												<tr>
													<td class="align-middle">${item.address}</td>
													<fmt:formatDate value="${item.createDate}" var="createDate"
														pattern="dd/MM/yyyy" />
													<td class="align-middle">${createDate}</td>
													
													<td class="align-middle">${item.account.fullname}</td>
													<td class="align-middle"><a href="/oderde/${item.id}"><button>Chi tiet</button></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="footer text-center">
				© 2023 FPT_Polytechnic <a href="#">FPT.edu.com</a>
			</footer>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery/dist/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/app-style-switcher.js"></script>
	<script src="<%=request.getContextPath()%>/js/waves.js"></script>
	<script src="<%=request.getContextPath()%>/js/sidebarmenu.js"></script>
	<script src="<%=request.getContextPath()%>/js/custom.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/flot/jquery.flot.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/pages/dashboards/dashboard1.js"></script>
</body>
</html>