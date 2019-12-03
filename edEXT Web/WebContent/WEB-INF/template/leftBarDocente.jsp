<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
	String nick = (String)session.getAttribute("nick_usuario");

%>
<div class="row">
	<div class="col-sm-2 left-menu" align="left">
		<ul class="nav nav-pills flex-column">
			<li class="nav-item active">
			<li class="nav-item">
				<!-- Mi perfil Estudiante-->
				<div class="card border-success mb-3" style="max-width: 18rem;">
					<div style="text-align: center;">
						<div class="card-header">
							<a class="nav-link" href="Perfil?nick=<%=nick%>"> <span class=""><i
									class="fa fa-user-circle-o"></i></span> &nbsp; Mi perfil
							</a>
						</div>
					</div>
					<ul class="list-group list-group-flush">
					<li class="list-group-item"><a href="Principal">Inicio</a></li>
						<li class="list-group-item"><a
							href="inicioDe?Tipo=Editar&Nick=<%=(String)session.getAttribute("nick_usuario")%>">Editar</a></li>
						
						<li class="list-group-item"><a href="CargarListasDatos?Tipo=Usuarios">Ver
								Perfiles</a></li>
						<li class="list-group-item"><a
							href="CargarListasDatos?Tipo=ProgramasFormacion">Programas de
								Formacion</a></li>
						<li class="list-group-item"><a href="CargarListasDatos?Tipo=Categorias">Categorias</a></li>
						<li class="list-group-item"><a href="CargarListasDatos?Tipo=Institutos">Institutos</a></li>
						<li class="list-group-item"><a
							href="inicioDe?Tipo=crearProgramaDeFormacion">Crear programa de
								formación</a></li>
					</ul>
				</div>
			</li>
		</ul>
	</div>