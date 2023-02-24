<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						<h3 class="page-title mb-0 p-0">Thêm mới</h3>
						<div class="d-flex align-items-center">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="<%=request.getContextPath()%>/">Home</a></li>
									<li class="breadcrumb-item"><a
										href="<%=request.getContextPath()%>/admin/account">Tài
											khoản</a></li>
									<li class="breadcrumb-item active" aria-current="page">
										Thêm mới</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid mb-5">
				<form:form action="store" method="post" modelAttribute="account"
					enctype="multipart/form-data">
					<div class="row">
						<div class="avatar-upload">
							<div class="avatar-edit">
								<form:input type="file" name="photo" path="photo"
									id="imageUpload" accept=".png, .jpg, .jpeg" />
								<form:errors class="text-danger" path="photo" />
								<label for="imageUpload"></label>
							</div>
							<div class="avatar-preview">
								<div id="imagePreview"
									style="background-image: url(<%=request.getContextPath()%>/images/account/userdefault.png);">
								</div>
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6 mt-md-0 mt-3">
							<label>Họ và tên</label>
							<form:input type="text" name="fullname" path="fullname"
								class="form-control" required="" />
							<form:errors class="text-danger" path="fullname" />
						</div>
						<div class="col-md-6 mt-md-0 mt-3">
							<label>Username</label>
							<form:input type="text" name="username" path="username"
								class="form-control" required="" />
							<form:errors class="text-danger" path="username" />
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6 mt-md-0 mt-3">
							<label>Password</label>
							<form:input type="password" name="password" path="password"
								class="form-control" required="" />
							<form:errors class="text-danger" path="password" />
						</div>
						<div class="col-md-6 mt-md-0 mt-3">
							<div class="col-md-6 mt-md-0 mt-3">
								<label>Email</label>
								<form:input type="email" name="email" path="email"
									class="form-control" required="" />
								<form:errors class="text-danger" path="email" />
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6 mt-md-0 mt-3">
							<label>Activated</label>
							<div class="d-flex align-items-center mt-2">
								<label class="option"> <form:radiobutton
										name="activated" path="activated" value="1" checked="checked" />Kích
									hoạt<span class="checkmark"></span>
								</label> <label class="option ms-4"> <form:radiobutton
										name="activated" value="0" path="activated" />Chưa kích hoạt<span
									class="checkmark"></span>
								</label>
								<form:errors class="text-danger" path="activated" />
							</div>
						</div>
						<div class="col-md-6 mt-md-0 mt-3">
							<label>Phân quyền</label>
							<form:select name="admin" path="admin" required="">
								<form:option value="" selected="selected" hidden="hidden">Chọn role</form:option>
								<form:option value="ROLE_ADMIN">Admin</form:option>
								<form:option value="ROLE_USER">User</form:option>
							</form:select>
							<form:errors class="text-danger" path="admin" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary mt-3">Thêm</button>
				</form:form>
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