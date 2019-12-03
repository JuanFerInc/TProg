<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceUsuario"%>
<%@page import="com.intermediario.interfaceCurso"%>
<%@page import="publicador.UsuarioNoExisteExcep_Exception"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.edEXT.TipoSession"%>
<%@page import="publicador.DtInstancia"%>
<%@page import="publicador.DtEdicion"%>
<%@page import="publicador.DtInfo"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>

<%	
	DtEdicion edicion = (DtEdicion)request.getAttribute("Edicion");
	String nombreCurso = (String)request.getAttribute("nombreCurso");
	if(session.getAttribute("estado_sesion") == TipoSession.NO_LOGIN || session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE){
		
		String imagenURL = "media/imagenes/programadeformacion1.jpg";
		if(edicion.getFotito().compareTo("--") != 0){
			imagenURL = edicion.getFotito();
		}
	%>

<div class="container emp-profile">
	<form method="post">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL %>" alt="Foto de perfil"
						style="width: 225px; height: 200px;" />

				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=edicion.getNombre() %></h5>
					<h6>
						Edicion
						<%=Integer.toString(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getInicio()).get(Calendar.YEAR))  %></h6>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">Edicion seleccionada</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="profile-work">
					<p style="color: white">2+2=5</p>
				</div>
			</div>
			<div class="col-md-8">
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-6">
								<label>Nombre de la Edicion</label>
							</div>
							<div class="col-md-6">
								<p><%=edicion.getNombre() %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de inicio</label>
							</div>
							<div class="col-md-6">
							<% interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
								String s=u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getInicio()));
							%>
								<p><%=s%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de finalizacion</label>
							</div>
							<div class="col-md-6">
								<p><%=u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFin())) %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de publicacion</label>
							</div>
							<div class="col-md-6">
							<%
							int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.DAY_OF_MONTH);
							int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.MONTH);
							m=m+1;
							int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.YEAR);
							String date = Integer.toString(d) + '/'
										+ Integer.toString(m) + '/'
										+ Integer.toString(y);
							%>
								<p><%=date %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Cupos</label>
							</div>
							<div class="col-md-6">
								<%
							String cupos = "No tiene limite";
							if(edicion.getCupo()!= -1){
								cupos = Integer.toString(edicion.getCupo());
							}
							%>

								<p><%=cupos %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="docentes">Docentes</label> <select
									class="custom-select d-block w-100" id="docentes" required>
									<%
									for(String i: edicion.getDocentesParticipan()){								
									%>
									<option><%=i %></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
							<div class="col-md-6">
								<a href="comentarios?nombreEdicion=<%=java.net.URLEncoder.encode(edicion.getNombre(), "UTF-8") %>&nombreCurso=<%=java.net.URLEncoder.encode(nombreCurso, "UTF-8") %>" 
									class="btn btn-default">Ver Comentarios</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>


<%
	}else if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE){
		String imagenURL = "media/imagenes/programadeformacion1.jpg";
		if(edicion.getFotito().compareTo("--") != 0){
			imagenURL = edicion.getFotito();
		}
	%>


<div class="container emp-profile">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL%>" alt="Foto de perfil"
						style="width: 225px; height: 200px;" />

				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=edicion.getNombre() %></h5>
					<h6>
						Edicion 
						<%=Integer.toString(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getInicio()).get(Calendar.YEAR))  %></h6>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
						<li class="nav-item"><a class="nav-link"
							id="inscriptions-tab" data-toggle="tab" href="#inscriptions"
							role="tab" aria-controls="inscriptions" aria-selected="false">Estudiantes
								inscriptos</a></li>
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
								<label>Nombre de la Edicion</label>
							</div>
							<div class="col-md-6">
								<p><%=edicion.getNombre() %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de inicio</label>
							</div>
							<div class="col-md-6">
							<% interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
								
							%>
								<p><%=u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getInicio())) %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de finalizacion</label>
							</div>
							<div class="col-md-6">
								<p><%=u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFin())) %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de publicacion</label>
							</div>
							<div class="col-md-6">
							<%
							int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.DAY_OF_MONTH);
							int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.MONTH);
							m=m+1;
							int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.YEAR);
							String date = Integer.toString(d) + '/'
										+ Integer.toString(m) + '/'
										+ Integer.toString(y);
							%>
								<p><%=date %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Cupos</label>
							</div>
							<div class="col-md-6">
								<%
							String cupos = "No tiene limite";
							if(edicion.getCupo()!= -1){
								cupos = Integer.toString(edicion.getCupo());
							}
							%>

								<p><%=cupos %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="docentes">Docentes</label> <select
									class="custom-select d-block w-100" id="docentes" required>
									<%
									boolean flag=false;
									String yo=(String)session.getAttribute("nick_usuario");
									for(String i: edicion.getDocentesParticipan()){	
										if(yo.equals(i)) {
											flag=true;
										}
									%>
									<option><%=i %></option>
									<%
									}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="tab-pane fade show" id="inscriptions"
						role="tabpanel" aria-labelledby="inscriptions-tab">
						<%interfaceUsuario ui=Fabrica.getInstancia().getIUsuario();
						int notita;
						interfaceCurso ic=Fabrica.getInstancia().getICurso();
						List<DtInfo> inscriptos = (List<DtInfo>)request.getAttribute("Inscriptos"); %>
						<table style="width: 100%">
						<%if(!inscriptos.isEmpty()){ %>
						  <tr>
    						<th>Nick</th>
   							<th>Fecha</th> 
   							<th>Nota</th>
   							<th>Video</th>
  							</tr>
						<%
							DtInfo dato;
							Calendar feccha;
							for(int i = 0; i < inscriptos.size(); i++){
								dato = inscriptos.get(i);
									if(dato.getEstado().compareTo("Aceptada") == 0){
							%>
							<tr>
								<td><%=dato.getNick() %></td>
								<td><%=ui.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(dato.getFechaInscripcion())) %></td>
								<%
								try{
								notita=ic.verCorreccion(edicion.getNombre(), dato.getNick(), false);
								} catch (UsuarioNoExisteExcep_Exception e) {
									notita=0;
								}
								if (flag) {
									if (notita!=-1){
									%>
								<td><%=notita %></td>
								<%} else {
								%>
								<td><p>No fue calificado</p></td>
									<% 
								}
								} else {%>
								<td><p>no es docente de esta edicion</p></td>
								<%} %>
								<td>
								<%
								String videoURL="https://www.youtube.com/embed/Z2nns-WOd6M";
								try{
									videoURL=ic.verVideoDeInscripcion(edicion.getNombre(), dato.getNick() );
					  				} catch (UsuarioNoExisteExcep_Exception e) {
					  				 videoURL ="https://www.youtube.com/embed/Z2nns-WOd6M";
					  				//https://www.youtube.com/embed/Z2nns-WOd6M
					  				}
								%>
								<iframe width="250" height="170" src=<%=videoURL %> frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
								</td>
							</tr>
							
							<%
								}
							}
				} else {
							%>
							<p>No hay estudiantes inscriptos</p>
							<%} %>
							
						</table>
						</div>
						<hr class="mb-4">
						<div class="row">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
							<div class="col-md-6">
								<a href="comentarios?nombreEdicion=<%=java.net.URLEncoder.encode(edicion.getNombre(), "UTF-8") %>&nombreCurso=<%=java.net.URLEncoder.encode(nombreCurso, "UTF-8") %>" 
									class="btn btn-default">Ver Comentarios</a>
							</div>

						</div>
					</div>

				</div>
			</div>
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

