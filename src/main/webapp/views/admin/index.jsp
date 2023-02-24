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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<%@include file="header.jsp"%>
		<%@include file="menu.jsp"%>
		<div class="page-wrapper">
			<div class="page-breadcrumb">
				<div class="row align-items-center"></div>
			</div>
			<div class="container-fluid"></div>
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