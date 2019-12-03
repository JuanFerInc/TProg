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
<title>Alta de Edicion de Curso</title>
</head>
<body>
	<div>

		<%if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE){
			%>
		<div>
			<jsp:include page="/WEB-INF/template/topBarLogeado.jsp" />
		</div>
		<% 
		}else if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE){
			%>
		<div>
			<jsp:include page="/WEB-INF/template/topBarLogeado.jsp" />
		</div>
		<% 
		}else{
			%>
		<div>
			<jsp:include page="/WEB-INF/template/topBarVisitante.jsp" />
		</div>
		<% 
		}%>

		<%if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE){
			%>
		<jsp:include page="/WEB-INF/template/leftBarDocente.jsp" />
		<div class="col-7 py-4" align="left">
			<% 
		}else if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE){
			%>
			
			<jsp:include page="/WEB-INF/template/leftBarEstudiante.jsp" />
		<div class="col-7 py-4" align="left">
			<% 
		}else{
			%>
			<jsp:include page="/WEB-INF/template/leftBarVisitante.jsp" />
			<div class="col-7 py-4" align="left">
				<% 
		}%>
		
			<%
		if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE){
		%>
		
				<jsp:include page="/WEB-INF/template/altaProgramaDeFormacion.jsp" />


		<%
		}else{
			
		
		
		%>
		<jsp:include page="/WEB-INF/template/404.jsp" />
		
		<%
		}
		%>

				




				<!--FIN div class col-7-->
			</div>
		</div>


		<div>
			<jsp:include page="/WEB-INF/template/footer.jsp" />
		</div>
</body>
</html>