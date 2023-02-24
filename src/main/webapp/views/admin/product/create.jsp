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
										href="<%=request.getContextPath()%>/admin">Home</a></li>
									<li class="breadcrumb-item"><a
										href="<%=request.getContextPath()%>/admin/product">Sản
											phẩm</a></li>
									<li class="breadcrumb-item active" aria-current="page">
										Thêm mới</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid mb-5">
				<form:form action="store" method="post" modelAttribute="product"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-4 mb-5">
							<div class="avatar-upload-product">
								<div class="avatar-edit-product">
									<form:input type="file" name="image" path="image"
										id="imageUpload" accept=".png, .jpg, .jpeg" />
									<form:errors class="text-danger" path="image" />
									<label for="imageUpload"></label>
								</div>
								<div class="avatar-preview-product">
									<div id="imagePreview"
										style="background-image: url(<%=request.getContextPath()%>/images/product/product_default.png);">
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-8 mb-5">
							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<label>Tên sản phẩm</label>
										<form:input type="text" name="name" path="name"
											class="form-control" required="" />
										<form:errors class="text-danger" path="name" />
									</div>
									<div class="form-group">
										<label>Đơn giá</label>
										<form:input type="number" name="price" path="price"
											class="form-control " required="" />
										<form:errors class="text-danger" path="price" />
									</div>
									<div class="form-group">
										<label>Thể loại</label>
										<div class="col-sm-12 border-bottom">
											<form:select class=" form-select shadow-none border-0 ps-0 "
												id="sub" name="category" path="category" required="">
												<form:option value="0" selected="selected" hidden="hidden">Chọn thể loại</form:option>
												<c:forEach var="item" items="${categories}">
													<form:option value="${item.id}">${item.name}</form:option>
												</c:forEach>
											</form:select>
										</div>
										<form:errors class="text-danger" path="category" />
									</div>
									<div class="form-group">
										<label>Available</label>
										<div class="d-flex align-items-center mt-2">
											<label class="option"> <form:radiobutton
													name="available" path="available" value="0"
													checked="checked" />True<span class="checkmark"></span>
											</label> <label class="option ms-4"> <form:radiobutton
													name="available" value="1" path="available" />False<span
												class="checkmark"></span>
											</label>
											<form:errors class="text-danger" path="available" />
										</div>
									</div>
									<button type="submit" class="btn btn-primary mt-3">Thêm</button>
								</div>
							</div>
						</div>
					</div>
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