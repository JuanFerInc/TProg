<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceCurso"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.edEXT.TipoSession"%>

<%
	if (session.getAttribute("estado_sesion") == TipoSession.NO_LOGIN) {
		List<String> Cursos = (List<String>) request.getAttribute("ListaCursos");
		for (String i : Cursos) {
%>
<!-- div class col-7  es necesario para que se mantengan en forma las cajitas-->

<div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=i%>
					</div>
					<div class="text-right">
						<div class="btn-group">
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Opciones</button>
							<div class="dropdown-menu dropdown-menu-right">
								<button class="dropdown-item"
									onclick="window.location.href = 'CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(i, "UTF-8")  %>';"
									type="button">Ver Datos</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
		
	} else if (session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE) {
		List<String> Cursos = (List<String>) request.getAttribute("ListaCursos");
		for (String i : Cursos) {
%>
<!-- div class col-7  es necesario para que se mantengan en forma las cajitas-->

<div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=i%></div>
					<div class="text-right">
						<div class="btn-group">
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Opciones</button>
							<div class="dropdown-menu dropdown-menu-right">
								<%
									if (request.getAttribute("NombreInsituto") != null) {
								%>
								<button class="dropdown-item"
									onclick="window.location.href = 'inicioDe?Tipo=AltaDeEdicionDeCurso&Instituto=<%=java.net.URLEncoder.encode((String)request.getAttribute("NombreInsituto"), "UTF-8")%>&nombreCurso=<%=java.net.URLEncoder.encode(i, "UTF-8") %>';"
									type="button">Alta
									Edicion de Curso</button>

								<%
									}
								%>
								<button class="dropdown-item"
									onclick="window.location.href = 'CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(i, "UTF-8") %>';"
									type="button">Ver Datos</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
		
	} else if (session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE) {
		List<String> Cursos = (List<String>) request.getAttribute("ListaCursos");
		for (String i : Cursos) {
%>
<!-- div class col-7  es necesario para que se mantengan en forma las cajitas-->

<div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=i%>
					</div>
					<div class="text-right">
						<div class="btn-group">
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Opciones</button>
							<div class="dropdown-menu dropdown-menu-right">
								<button class="dropdown-item"
									onclick="window.location.href = 'CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(i, "UTF-8") %>';"
									type="button">Ver Datos</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
		
	}
%>