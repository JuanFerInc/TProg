<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@page import="com.edEXT.TipoSession"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Inicio Sesion</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="media/css/inicioSesion.css" rel="stylesheet">
</head>
<body>
	<%if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
	%>
	<form action="atenderLogin" class="form-signin" method="post">
		<div class="text-center mb-4">
			<img class="mb-4" src="media/imagenes/inicioSesion.png" alt="" width="200"
				height="72">
			<h1 class="h3 mb-3 font-weight-normal">Inicio Sesion</h1>
			<%
			if((request.getAttribute("error_login")!= null)){
				%>
				
				 <font color="red"><%=request.getAttribute("error_login") %></font>
				
				
			<%
			}
			%>
			
		</div>

		<div class="form-label-group">
			<input name="inputID" type="text" class="form-control" 
				placeholder="nick o email" value=""  required>
			<label for="inputID">Correo o Nickname</label>
		</div>

		<div class="form-label-group">
			<input name="inputPassword" type="password"  class="form-control"
				placeholder="Password" required> <label for="inputPassword">Password</label>
		</div>
		<input type="submit" value="Sign In" class="btn btn-info"/>
		<hr class="mb-4">
		<p class="mt-5 mb-3 text-muted text-center">&copy; 2019-2019</p>
	</form>
	<%
	}else{
	%>
		<jsp:include page="/WEB-INF/template/404.jsp" />
	<%
	}
	%>
</body>
</html>
