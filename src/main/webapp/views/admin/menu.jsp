<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<aside class="left-sidebar" data-sidebarbg="skin6">
		<div class="scroll-sidebar">
			<nav class="sidebar-nav">
				<ul id="sidebarnav">
					<li class="sidebar-item"><a
						class="sidebar-link waves-effect waves-dark sidebar-link"
						href="<%=request.getContextPath()%>/admin/thong-tin"
						aria-expanded="false"><i class="fa fa-info me-3"></i><span
							class="hide-menu">Thông tin</span></a></li>
					<li class="sidebar-item"><a
						class="sidebar-link waves-effect waves-dark sidebar-link"
						href="<%=request.getContextPath()%>/admin/product"
						aria-expanded="false"> <i class="me-3 fa fa-cube fs-3"
							aria-hidden="true"></i><span class="hide-menu">Sản phẩm</span>
					</a></li>
					<li class="sidebar-item"><a
						class="sidebar-link waves-effect waves-dark sidebar-link"
						href="<%=request.getContextPath()%>/admin/category"
						aria-expanded="false"> <i class="me-3 fa fa-cubes fs-3"
							aria-hidden="true"></i><span class="hide-menu">Thể loại</span>
					</a></li>
					<li class="sidebar-item"><a
						class="sidebar-link waves-effect waves-dark sidebar-link"
						href="<%=request.getContextPath()%>/admin/order"
						aria-expanded="false"> <i
							class="me-3 fa fa-shopping-cart fs-3" aria-hidden="true"></i><span
							class="hide-menu">Hóa đơn</span>
					</a></li>
					<li class="sidebar-item"><a
						class="sidebar-link waves-effect waves-dark sidebar-link"
						href="/admin/account" aria-expanded="false"> <i
							class="me-3 fa fa-user fs-3" aria-hidden="true"></i><span
							class="hide-menu">Tài khoản</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</aside>
</body>
</html>