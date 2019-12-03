<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.edEXT.TipoSession"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/header.jsp" />
<meta charset="ISO-8859-1">
<title>Lista de Cursos Mobile</title>
</head>
<body>
	<div>

		<%if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
			%>
		<div>
			<jsp:include page="/WEB-INF/template/topBarMobile.jsp" />
		</div>
		<div>
			<jsp:include page="/WEB-INF/template/listarCursosMobile.jsp" />
		</div>
		<%}else{ %>
			<jsp:include page="/WEB-INF/template/404.jsp" />
		
		<%} %>
	</div>


		
</body>
</html>