<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.edEXT.TipoSession"%>

<%	
	if(session.getAttribute("estado_sesion") == TipoSession.NO_LOGIN){
		List<String> Institutos = (List<String>)request.getAttribute("ListaInstitutos");
		for (String i : Institutos) {
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
								<button class="dropdown-item"
									onclick="window.location.href = 'CargarCursos?arg1=Instituto&arg2=<%=i %>';"
									type="button">Ver Cursos</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%		}
		
	}else if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE){
		List<String> Institutos = (List<String>)request.getAttribute("ListaInstitutos");
		for (String i : Institutos) {
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
								<button class="dropdown-item"
									onclick="window.location.href = 'CargarCursos?arg1=Instituto&arg2=<%=i %>';"
									type="button">Ver Cursos</button>
								<button class="dropdown-item"
									onclick="window.location.href = 'inicioDe?Tipo=AltaDeCurso&Instituto=<%=i %>';" type="button">Alta
									de Curso</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%}
		
		}else if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE){
		List<String> Institutos = (List<String>)request.getAttribute("ListaInstitutos");
		for (String i : Institutos) {
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
								<button class="dropdown-item"
									onclick="window.location.href = 'CargarCursos?arg1=Instituto&arg2=<%=i %>';"
									type="button">Ver Cursos</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%}
		
		} %>
