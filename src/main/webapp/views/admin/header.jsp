<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="topbar" data-navbarbg="skin6">
		<nav class="navbar top-navbar navbar-expand-md navbar-dark">
			<div class="navbar-header" data-logobg="skin6">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/admin">
					<b class="logo-icon"> <img
						src="<%=request.getContextPath()%>/images/FPT_Polytechnic.png"
						alt="homepage" class="dark-logo img-fluid p-3" />
				</b>
				</a> <a
					class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
					href="javascript:void(0)"><i class="fa fa-search"></i></a>
			</div>
			<div class="navbar-collapse collapse" id="navbarSupportedContent"
				data-navbarbg="skin5">
				<ul class="navbar-nav me-auto mt-md-0">
					<li class="nav-item hidden-sm-down">
						<form class="app-search ps-3">
							<input type="text" class="form-control"
								placeholder="Search for..." /> <a class="srh-btn"><i
								class="fa fa-search"></i></a>
						</form>
					</li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDarkDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <img
							src="<%=request.getContextPath()%>/images/account/user.jpg"
							alt="user" class="profile-pic me-2" />
					</a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
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
	</header>
</body>
</html>