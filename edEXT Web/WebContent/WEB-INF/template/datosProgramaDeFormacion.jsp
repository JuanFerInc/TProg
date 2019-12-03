<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.edEXT.TipoSession"%>
<%@page import="publicador.DtPrograma"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Set"%>

<%
	DtPrograma Programa = (DtPrograma) request.getAttribute("DatosPrograma");

	String imagenURL = "media/imagenes/programadeformacion1.jpg";
	if(Programa.getFotito().compareTo("--") != 0){
		imagenURL = Programa.getFotito();
	}
%>

<%
	if (session.getAttribute("estado_sesion") == TipoSession.NO_LOGIN) {
%>


<div class="container emp-profile">
	<form method="post">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL%>" alt="Foto de perfil"
						style="width: 225px; height: 200px;" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=Programa.getNombre()%></h5>
					<h6>
						Programa de Formacion
						</h6>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="profile-work">
					<p style="color: white">WORK LINK</p>
				</div>
			</div>
			<div class="col-md-8">
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-6">
								<label>Nombre del programa</label>
							</div>
							<div class="col-md-6">
								<p><%=Programa.getNombre()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de inicio</label>
							</div>
							<div class="col-md-6">
								<%
								interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
								String dateinicio=IUsuario.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Programa.getInicio()));
								%>
								<p><%=dateinicio%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de finalizacion</label>
							</div>
							<div class="col-md-6">
								<%
									String datefin = IUsuario.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Programa.getFin()));
								%>
								<p><%=datefin%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Descripcion</label>
							</div>
							<div class="col-md-6">
								<p><%=Programa.getDescripcion()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h5 align="center">Categorias</h5>

								<%
									if (!Programa.getCategorias().isEmpty()) {

											for (String categorias : Programa.getCategorias()) {
								%>
								<div class="col-md-6">
									<p><%=categorias%></p>
								</div>

								<%
									}
										} else {
								%>
								<div class="col-md-6">
									<a id="NoContieneCategorias" target="_self">No Tiene
										Categorias</a>
								</div>

								<%
									}
								%>


							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h5 aling="center">Cursos</h5>
								<table style="width: 100%">
									<%
										if (!Programa.getCursos().isEmpty()) {

												for (String cursos : Programa.getCursos()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(cursos, "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=cursos%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContieneCursos" target="_self">No Tiene
												Cursos</a></td>
									</tr>

									<%
										}
									%>

								</table>

							</div>

						</div>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
</div>


<%
	} else if (session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE) {
%>

<div class="container emp-profile">
	<form
		action="altaDe?Tipo=AgregarCursosAProgramas&NombrePF=<%=Programa.getNombre()%>"
		method="post">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL%>" alt="Foto de perfil"
						style="width: 225px; height: 200px;" />

				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=Programa.getNombre()%></h5>
					<h6>
						Programa de Formacion
						</h6>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
						<li class="nav-item"><a class="nav-link" id="profile-tab"
							data-toggle="tab" href="#profile" role="tab"
							aria-controls="profile" aria-selected="false">Agregar curso a
								programa</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="profile-work">
					<p style="color: white">WORK LINK</p>
				</div>
			</div>
			<div class="col-md-8">
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-6">
								<label>Nombre del programa</label>
							</div>
							<div class="col-md-6">
								<p><%=Programa.getNombre()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de inicio</label>
							</div>
							<div class="col-md-6">
								<%
									interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
									String dateinicio =u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Programa.getInicio()));
								%>
								<p><%=dateinicio%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de finalizacion</label>
							</div>
							<div class="col-md-6">
								<%
									String datefin = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Programa.getFin()));
								%>
								<p><%=datefin%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Descripcion</label>
							</div>
							<div class="col-md-6">
								<p><%=Programa.getDescripcion()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h4 aling="center">Categorias</h4>
								<table style="width: 100%">
									<%
										if (!Programa.getCategorias().isEmpty()) {

												for (String categorias : Programa.getCategorias()) {
									%>

									<tr>
										<td><%=categorias%></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContieneCategorias" target="_self">No
												Tiene Categorias</a></td>
									</tr>

									<%
										}
									%>

								</table>

							</div>
						</div>
						<div class="row">
							<div class="col-md-12">

								<h4 align="center">Cursos</h4>
								<table style="width: 100%">
									<%
										if (!Programa.getCursos().isEmpty()) {
												for (String cursos : Programa.getCursos()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(cursos, "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=cursos%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<a id="NoContieneCursos" target="_self">No Tiene Cursos</a>
									</tr>

									<%
										}
									%>

								</table>
							</div>

						</div>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<%
							Set<String> cursos = (Set<String>) request.getAttribute("cursosSinPrograma");
								if (!cursos.isEmpty()) {
									for (String curso : cursos) {
						%>
						<div class="row">
							<div class="col-md-6">
								<label><%=curso%></label>
							</div>
							<div class="mb-3">
								<input type="checkbox" name="cursos" value="<%=curso%>">
								seleccione para agregar<br>
							</div>
						</div>
						<%
							}
								}
						%>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6 mb-3">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
							<div class="col-md-6 mb-3">
								<button class="btn btn-primary btn-lg btn-block" type="submit">Realizar
									cambios</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<%
	} else if (session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE) {
%>


<div class="container emp-profile">
	<form method="post">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL%>" alt="Foto de perfil"
						style="width: 225px; height: 200px;" />

				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=Programa.getNombre()%></h5>
					<h6>
						Programa de Formacion
						</h6>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="profile-work">
					<p style="color: white">WORK LINK</p>
				</div>
			</div>
			<div class="col-md-8">
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-6">
								<label>Nombre del programa</label>
							</div>
							<div class="col-md-6">
								<p><%=Programa.getNombre()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de inicio</label>
							</div>
							<div class="col-md-6">
								<%
								interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
									String dateinicio =u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Programa.getInicio()));
								%>
								<p><%=dateinicio%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de finalizacion</label>
							</div>
							<div class="col-md-6">
								<%
									String datefin = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Programa.getFin()));
								%>
								<p><%=datefin%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Descripcion</label>
							</div>
							<div class="col-md-6">
								<p><%=Programa.getDescripcion()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h4 align="center">Categorias</h4>
								<table style="width: 100%">
									<%
										if (!Programa.getCategorias().isEmpty()) {

												for (String categorias : Programa.getCategorias()) {
									%>

									<tr>
										<td><%=categorias%></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContieneCategorias" target="_self">No
												Tiene Categorias</a></td>
									</tr>

									<%
										}
									%>

								</table>

							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h4 align="center">Cursos</h4>
								<table style="width: 100%">
									<%
										if (!Programa.getCursos().isEmpty()) {

												for (String cursos : Programa.getCursos()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(cursos, "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=cursos%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContieneCursos" target="_self">No Tiene
												Cursos</a></td>
									</tr>

									<%
										}
									%>

								</table>

							</div>

						</div>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
							<div class="col-md-6">
								<a href="" type="submit" class="btn btn-info"
									id="linksuscribirme" target="_self" role="button">Suscribirme</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<%
	}
%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>


