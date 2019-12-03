<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.edEXT.TipoSession"%>
<%@page import="com.intermediario.Fabrica" %>
<%@page import="publicador.DtUsuario"%>
<%@page import="publicador.DtDocente"%>
<%@page import="publicador.DtEstudianteIn"%>
<%@page import="publicador.DtInstancia"%>
<%@page import="java.util.Calendar"%>
<%
	DtUsuario DtU = (DtUsuario) request.getAttribute("DtUsuario");
	DtDocente DtD;
	DtEstudianteIn DtE;

	if (DtU instanceof DtEstudianteIn) {
		DtE = (DtEstudianteIn) DtU;
		String imagenURL = "media/imagenes/programadeformacion1.jpg";
		if (DtE.getImagen().compareTo("--") != 0) {
			imagenURL = DtE.getImagen();
		}
%>


<div class="container emp-profile">
	<form action="altaDe?Tipo=CambiarDatosPerfil&Nick=<%=DtE.getNick()%>"
		method="post">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src=<%=imagenURL%> alt="Foto de perfil"
						style="width: 225px; height: 200px;" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=(DtE.getNombre() + " " + DtE.getApellido())%></h5>
					<h6>Estudiante</h6>
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
					<p style="color: white">Hola profe, queremos salvar</p>
				</div>
			</div>
			<div class="col-md-8">
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-6">
								<label>Nick de usuario</label>
							</div>
							<div class="col-md-6">
								<p><%=DtE.getNick()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Nombre</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="Nombre"
									placeholder="<%=DtE.getNombre()%>" value="<%=DtE.getNombre()%>" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Apellido</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="Apellido"
									placeholder="<%=DtE.getApellido()%>" value="<%=DtE.getApellido()%>" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Email</label>
							</div>
							<div class="col-md-6">
								<p><%=DtE.getCorreo()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Contraseña</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="Password"
									placeholder="Ingrese Nueva Contraseña" >
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Verificacion Contraseña</label>
							</div>
							
							<div class="col-md-6">
								<input type="text" class="form-control"
									name="VerificationPassword" placeholder="Verifique Contraseña">
							</div>
						</div> 
						<div class="custom-control custom-checkbox">
					         <input type="checkbox" name="changePass" value="docente">Cambiar Contraseña<br>
					    </div>
						<div class="mb-3">
						<p>Fecha de nacimiento</p>
							<div class="col-md-12 mb-3">
								Dia : <input type="number" class="form-control" name="dia"
									min="1" max="31" value="<%=Integer.toString(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(DtE.getFechaNacimiento()).get(Calendar.DAY_OF_MONTH)) %>" required>
								<div class="invalid-feedback">Por favor ingresa un dia
									valido.</div>
							</div>
							<div class="col-md-12 mb-3">
							<%
							int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(DtE.getFechaNacimiento()).get(Calendar.MONTH);
							int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(DtE.getFechaNacimiento()).get(Calendar.YEAR);
							if(m == 0) {
								m = 12;
								y = y - 1;
							}
							%>
								Mes: <input type="number" class="form-control" name="mes"
									min="1" max="12" value="<%=m %>" required>
								<div class="invalid-feedback">Por favor ingresa un mes
									valido.</div>
							</div>
							<div class="col-md-12 mb-3">
								Año: <input type="number" class="form-control" name="anio"
									min="1" max="3000" value="<%=y %>" required>
								<div class="invalid-feedback">Por favor ingresa un año
									valido.</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>URL de la imagen</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="URLImagen"
									placeholder="<%=DtE.getImagen()%>" value="<%=DtE.getImagen()%>" >
							</div>
						</div>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6 mb-3">
								<a href="Principal" class="btn btn-info" id="home" role="button">Home</a>
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
	} else {
		DtD = (DtDocente) DtU;
		String imagenURL = "media/imagenes/programadeformacion1.jpg";
		if (DtD.getImagen().compareTo("--") != 0) {
			imagenURL = DtD.getImagen();
		}
%>



<div class="container emp-profile">
	<form action="altaDe?Tipo=CambiarDatosPerfil&Nick=<%=DtD.getNick()%>"
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
					<h5><%=(DtD.getNombre() + " " + DtD.getApellido())%></h5>
					<h6>Docente</h6>
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
								<label>Nick</label>
							</div>
							<div class="col-md-6">
								<p><%=DtD.getNick()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Nombre</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="Nombre"
									placeholder="<%=DtD.getNombre()%>" value="<%=DtD.getNombre()%>" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Apellido</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="Apellido"
									placeholder="<%=DtD.getApellido()%>" value="<%=DtD.getApellido()%>" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Email</label>
							</div>
							<div class="col-md-6">
								<p><%=DtD.getCorreo()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Contraseña</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="Password"
									placeholder="Ingrese Nueva Contraseña" >
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Verificacion Contraseña</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control"
									name="VerificationPassword" placeholder="Verifique Contraseña">
							</div>
						</div>
						 <div class="custom-control custom-checkbox">
					        <input type="checkbox" name="changePass" value="docente">Cambiar Contraseña<br>
					     </div>
      

						<div class="mb-3">
						<p>Fecha de nacimiento</p>
							<div class="col-md-12 mb-3">
								Dia : <input type="number" class="form-control" name="dia"
									min="1" max="31" value="<%=Integer.toString(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(DtD.getFechaNacimiento()).get(Calendar.DAY_OF_MONTH)) %>" required>
								<div class="invalid-feedback">Por favor ingresa un dia
									valido.</div>
							</div>
							<div class="col-md-12 mb-3">
							<%
							int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(DtD.getFechaNacimiento()).get(Calendar.MONTH);
							int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(DtD.getFechaNacimiento()).get(Calendar.YEAR);
							if(m == 0) {
								m = 12;
								y = y - 1;
							}
							%>
								Mes: <input type="number" class="form-control" name="mes"
									min="1" max="12" value="<%=m %>"required>
								<div class="invalid-feedback">Por favor ingresa un mes
									valido.</div>
							</div>
							<div class="col-md-12 mb-3">
								Año: <input type="number" class="form-control" name="anio"
									min="1" max="3000" value="<%=y %>" required>
								<div class="invalid-feedback">Por favor ingresa un año
									valido.</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>URL de la imagen</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" name="URLImagen"
									placeholder="<%=DtD.getImagen()%>" value="<%=DtD.getImagen()%>" required>
							</div>
						</div>
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
