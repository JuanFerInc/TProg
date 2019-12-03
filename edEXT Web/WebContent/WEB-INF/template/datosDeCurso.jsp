
<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceUsuario"%>
<%@page import="com.intermediario.interfaceCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.edEXT.TipoSession"%>
<%@page import="publicador.DtCurso"%>
<%@page import="publicador.DtInstancia"%>
<%@page import="publicador.DtEdicion"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>

<%@page import="publicador.UsuarioNoExisteExcep_Exception"%>

<%
	DtCurso Curso = (DtCurso) request.getAttribute("DatosCurso");

	String imagenURL = "media/imagenes/programadeformacion1.jpg";
	if (Curso.getImagen().compareTo("--") != 0) {
		imagenURL = Curso.getImagen();
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
					<h5><%=Curso.getNombre()%></h5>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
						<li class="nav-item"><a class="nav-link" id="profile-tab"
							data-toggle="tab" href="#profile" role="tab"
							aria-controls="profile" aria-selected="false">Edicion vigente</a>
						</li>
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
								<label>Nombre del curso</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getNombre()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Descripcion</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getDescripcion()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Creditos</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getCreditos()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Duracion</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getDuracion()%>
									Semanas
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Horas</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getHoras()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de registro</label>
							</div>
							<div class="col-md-6">
								<%
								interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
								int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.DAY_OF_MONTH);
								int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.MONTH);
								m=m+1;
								int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.YEAR);
								String date = Integer.toString(d) + '/'
											+ Integer.toString(m) + '/'
											+ Integer.toString(y);
							
								%>
								<p><%=date%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>URL</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getURL()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h4 align="center">Ediciones previas</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getEdiciones().isEmpty()) {

												for (String edicionPrevia : Curso.getEdiciones()) {
									%>

									<tr>
										<td><a
											href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(edicionPrevia, "UTF-8")%>&NombreCurso=<%=java.net.URLEncoder.encode(Curso.getNombre(), "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=edicionPrevia%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No Tiene
												Edicion Previa</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>

						</div>
						<div class="row">
							<div class="col-md-6">
								<h4 align="center">Cursos Previa</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getPrevias().isEmpty()) {

												for (String previas : Curso.getPrevias()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(previas, "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=previas%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No tiene
												previas</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<h4 align="center">Programas de formacion que integra</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getProgramas().isEmpty()) {

												for (String programaFormacion : Curso.getProgramas()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeProgramaDeFormacion?NombrePF=<%=java.net.URLEncoder.encode(programaFormacion, "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=programaFormacion%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No
												Integra Programa de formacion</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>
						</div>
						<hr class="mb-4">
						<div class="col-md-6">
							<button class="btn btn-info"
								onclick="window.location.href = 'Principal';" type="button">Home</button>
						</div>
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<%
							if (request.getAttribute("DatosEdicionActual") != null) {
									DtInstancia edicionVigente = (DtInstancia) request.getAttribute("DatosEdicionActual");
									if (edicionVigente instanceof DtEdicion) {
										DtEdicion edi = (DtEdicion) edicionVigente;
						%>



						<div class="row">
							<div class="col-md-6">
								<label>Cupos</label>
							</div>
							<div class="col-md-6">
							<%
							String cupos = "No tiene limite";
							if(edi.getCupo()!= -1){
								cupos = Integer.toString(edi.getCupo());
							}
							%>
								<p><%=cupos%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de Inicio</label>
							</div>
							<div class="col-md-6">
								<%
									String date1 =u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edi.getInicio()));
								%>
								<p><%=date1%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de Fin</label>
							</div>
							<div class="col-md-6">
								<%
									String date2 = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edi.getFin()));
								%>
								<p><%=date2%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de publicacion</label>
							</div>
							<div class="col-md-6">
								<%
								int d1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edi.getFechaPublicacion()).get(Calendar.DAY_OF_MONTH);
								int m1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edi.getFechaPublicacion()).get(Calendar.MONTH);
								m1=m1+1;
								int y1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edi.getFechaPublicacion()).get(Calendar.YEAR);
								String date3 = Integer.toString(d1) + '/'
											+ Integer.toString(m1) + '/'
											+ Integer.toString(y1);
									
								%>
								<p><%=date3%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="docentes">Docentes de la edicion</label> <select
									class="custom-select d-block w-100" id="docentes" required>
									<%
										if (!edi.getDocentesParticipan().isEmpty()) {

														for (String docente : edi.getDocentesParticipan()) {
									%>
									<option><%=docente%></option>
									<%
										}
									%>
								</select>
								<%
									} else {
								%>
								<p>No tiene docentes</p>
								<%
									}
								%>

							</div>
						</div>
						<%
							}
						%>
						<hr class="mb-4">

					</div>


					<%
						} else {
					%>

					<div class="row">
						<h2>No Existe Edicion Vigente</h2>
					</div>
				</div>

				<%
					}
				%>

			</div>
		</div>
	</form>	
	</div>
	</div>


<%
	} else if (session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE) {
%>

<div class="container emp-profile">
	
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL%>" alt="Foto de perfil" style="width: 225px; height: 200px;" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=Curso.getNombre()%></h5>
					 	<%
			if(request.getAttribute("error")!= null){
				%>
				
				 <font color="red"><%=request.getAttribute("error") %></font>
				
				
				<%
				
			}
			%>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
						<li class="nav-item"><a class="nav-link" id="profile-tab"
							data-toggle="tab" href="#profile" role="tab"
							aria-controls="profile" aria-selected="false">Edicion vigente</a>
						</li>
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
								<label>Nombre del curso</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getNombre()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Descripcion</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getDescripcion()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Creditos</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getCreditos()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Duracion</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getDuracion()%>
									Semanas
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Horas</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getHoras()%></p>
							</div>
						</div>
						<div class="row">

							<div class="col-md-6">
								<label>Fecha de registro</label>
							</div>
							<div class="col-md-6">
								<%
								interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
									int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.DAY_OF_MONTH);
									int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.MONTH);
									m=m+1;
									int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.YEAR);
									String date = Integer.toString(d) + '/'
												+ Integer.toString(m) + '/'
												+ Integer.toString(y);
								%>
								<p><%=date%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>URL</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getURL()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h4 align="center">Ediciones previas</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getEdiciones().isEmpty()) {

												for (String edicionPrevia : Curso.getEdiciones()) {
									%>

									<tr>
										<td><a href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(edicionPrevia, "UTF-8")%>&NombreCurso=<%=java.net.URLEncoder.encode(Curso.getNombre(), "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=edicionPrevia%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No Tiene
												Edicion Previa</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>

						</div>
						<div class="row">
							<div class="col-md-6">
								<h4 align="center">Cursos Previa</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getPrevias().isEmpty()) {

												for (String previas : Curso.getPrevias()) {
									%>

									<tr>
										<td><a href="CargarDatosDeCurso?nombreCurso=<%=previas%>"
											type="submit" id="linksuscribirme" target="_self"><%=previas%></a></td>
									</tr>
									<% 
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No tiene
												previas</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<h4 align="center">Programas de formacion que integra</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getProgramas().isEmpty()) {

												for (String programaFormacion : Curso.getProgramas()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeProgramaDeFormacion?NombrePF=<%=programaFormacion%>"
											type="submit" id="linksuscribirme" target="_self"><%=programaFormacion%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No
												Integra Programa de formacion</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>
						</div>
						<hr class="mb-4">
						<div class="col-md-6">
							<button class="btn btn-info"
								onclick="window.location.href = 'Principal';" type="button">Home</button>
						</div>
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<%
							if (request.getAttribute("DatosEdicionActual") != null) {
									DtInstancia edicionVigente = (DtInstancia) request.getAttribute("DatosEdicionActual");
									if (edicionVigente instanceof DtEdicion) {
										DtEdicion ed = (DtEdicion) edicionVigente;
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Cupos</label>
							</div>
							<div class="col-md-6">
							<% if (ed.getCupo()==-1) { %>
								<p>No tiene cupos</p>
								<%} else { %>
								<p> <%=ed.getCupo() %> </p>
								<%} %>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de Inicio</label>
							</div>
							<div class="col-md-6">
								<p>
									<%
										String date1 = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getInicio()));
									%>
								
								<p><%=date1%></p>
							
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de Fin</label>
							</div>
							<div class="col-md-6">
								<p>
									<%
										String date2 = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFin()));
									%>
								
								<p><%=date2%></p>
								
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de publicacion</label>
							</div>
							<div class="col-md-6">
								<p>
									<%
									int d1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFechaPublicacion()).get(Calendar.DAY_OF_MONTH);
									int m1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFechaPublicacion()).get(Calendar.MONTH);
									m1=m1+1;
									int y1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFechaPublicacion()).get(Calendar.YEAR);
									String date3 = Integer.toString(d1) + '/'
												+ Integer.toString(m1) + '/'
												+ Integer.toString(y1);
										
									%>
								
								<p><%=date3%></p>
								
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="docentes">Docentes de la edicion</label> <select
									class="custom-select d-block w-100" id="docentes" required>
									<%
										if (!ed.getDocentesParticipan().isEmpty()) {

														for (String docente : ed.getDocentesParticipan()) {
									%>
									<option><%=docente%></option>
									<%
										}
									%>
								</select>
								<%
									} else {
								%>
								<p>No tiene docentes</p>
								<%
									}
								%>
							</div>

						</div>
						<hr class="mb-4">
<%
		boolean flag=false;
		String nickdoc=(String)session.getAttribute("nick_usuario");
		if (!ed.getDocentesParticipan().isEmpty()) {
			for (String ea : ed.getDocentesParticipan()) {
			if (ea.equals(nickdoc)) {
				flag=true;
			}	
			}
		}
			
%>
						<div class="row">
							<p>Estudiantes pendientes</p>
						<hr class="mb-4">
				<%
				Set<String> inscripcionesPendientes = (Set<String>) request.getAttribute("InscripcionesPendientes");
				if (!inscripcionesPendientes.isEmpty()) {
				%>
				<table style="width:100%">
  				<tr>
    				<th>Nick</th>
    				<th>Video</th> 
    				<th>-</th>
  				</tr>
  				<%
  				interfaceCurso ic=Fabrica.getInstancia().getICurso();
  				String nom=Curso.getNombre();
				for (String ins : inscripcionesPendientes) {
				%>
  				
  				<%
  				String babayaga;
  				String videoURL;
  				try{
  				 babayaga=ic.verVideoDeInscripcion(ed.getNombre(), ins);
  				 videoURL=babayaga;
  				} catch (UsuarioNoExisteExcep_Exception e) {
  				 videoURL ="https://www.youtube.com/embed/Z2nns-WOd6M";
  				 babayaga="hola";
  				//https://www.youtube.com/embed/Z2nns-WOd6M
  				}
				%>
  				
  				
  				
  				
  				<tr>
   				<td><p><%=ins %> </p></td>
   				<td>
   				<iframe width="280" height="200" src=<%=videoURL %> frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
   				</td>
   				<% if (flag) { %>
    			<td><a href="AceptarCancelar?Tipo=Aceptada&cursito=<%=java.net.URLEncoder.encode(nom, "UTF-8")%>&nick=<%=ins%>" class="btn btn-info" role="button">Aceptar</a> <a href="AceptarCancelar?Tipo=rechazada&cursito=<%=java.net.URLEncoder.encode(nom, "UTF-8")%>&nick=<%=ins%>" class="btn btn-info" role="button">Rechazar</a></td>
  				<% } %>
  				</tr>
				<%
					}
				%>
				</table>
					<%
					} else {
					%>
					<div class="row">
					<p>No hay estudiantes pendientes</p>
					</div>
					<%
						}
					%>

					</div>
				
					<hr class="mb-4">
					<p> Estudiante inscriptos </p>
					<%
					String monica=Curso.getNombre();
					 %>
					<form action="altaDe?Tipo=notas&aceptadas=<%=java.net.URLEncoder.encode(monica, "UTF-8") %>"class="needs-validation" method="Post" >
					<%
					Set<String> inscripcionesAceptadas = (Set<String>) request.getAttribute("InscripcionesAceptadas");
					if (!inscripcionesAceptadas.isEmpty()) {
					%>
					
					<table style="width: 100%">
						<tr>
    				<th>Nick</th>
    				<th>Nota</th> 
  				</tr>
					<%
					interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
					boolean titi = ed.isBorrarBoton();
					
					if (titi){
					 for (String ins : inscripcionesAceptadas) {
						 Integer bambino=ICurso.verCorreccion( ed.getNombre(), ins, true);
					 %>
					 	<tr>
					<td><a href="Perfil?nick=<%=ins%>" type="submit" id="<%=ins%>" target="_self"><%=ins%></a></td>
					<td>
					<div class="col-md-6">
 					<input type="number" class="form-control" name="<%=ins%>" min="0" max="12" placeholder="nota anterior=<%=bambino %>" required>
 					</div>
					
					 </td>
					</tr>
					<%}
					%>
					 <% 
					} else {
					for (String ins : inscripcionesAceptadas) {
					%>
					<tr>
					<td><a href="Perfil?nick=<%=ins%>" type="submit" id="<%=ins%>" target="_self"><%=ins%></a></td>
					<td>
					<div class="col-md-6">
 					<input type="number" class="form-control" name="<%=ins%>" min="0" max="12"  required>
 					</div>
					
					 </td>
					</tr>

						<%
								}
					}
							%>
					</table>
					<%
							} else {
						%>
					<p>No hay estudiantes aceptados</p>
					<%
							}
						%>
					<hr class="mb-4">
					<div class="col-md-6">
					<%if (inscripcionesPendientes.isEmpty()){ %>
					<button class="btn btn-primary btn-lg btn-block" type="submit">Cierre de notas</button>
					<%
					if (ed.isBorrarBoton()){
						%>
						<hr class="mb-4">
						<a href="altaDe?Tipo=cierre&cursito=<%=java.net.URLEncoder.encode(monica, "UTF-8") %>" type="submit" id="cierre" target="_self" class="btn btn-info" role="button" >Cierre de edicion</a>
						<% 
					}
					} 
					%>
					</div>
					</form>
					<%
							}
								} else {
						%>

					<div class="row">
						<h2>No Existe Edicion Vigente</h2>
					</div>


					<%
						}
					%>


					</div>
			</div>
		</div>
</div>

</div>


<%
	} else if (session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE) {
%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #17a2b8;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #17a2b8;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: black;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>
</head>

<div class="container emp-profile">
	
		<div class="row">
			<%
			if(request.getAttribute("error")!= null){
				%>
				
				 <font color="red"><%=request.getAttribute("error") %></font>
				
				
				<%
				
			}
			%>
			<div class="col-md-4">
				<div class="profile-img">
					<img src="<%=imagenURL%>" alt="Foto de perfil"
						style="width: 225px; height: 200px;" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="profile-head">
					<h5><%=Curso.getNombre()%></h5>
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">General</a></li>
						<li class="nav-item"><a class="nav-link" id="profile-tab"
							data-toggle="tab" href="#profile" role="tab"
							aria-controls="profile" aria-selected="false">Edicion vigente</a>
						</li>
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
								<label>Nombre del curso</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getNombre()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Descripcion</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getDescripcion()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Creditos</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getCreditos()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Duracion</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getDuracion()%>
									Semanas
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Horas</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getHoras()%></p>
							</div>
						</div>
						<div class="row">

							<div class="col-md-6">
								<label>Fecha de registro</label>
							</div>
							<div class="col-md-6">
								<%
								interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
								int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.DAY_OF_MONTH);
								int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.MONTH);
								m=m+1;
								int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.YEAR);
								String date = Integer.toString(d) + '/'
											+ Integer.toString(m) + '/'
											+ Integer.toString(y);
							
								%>
								<p><%=date%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>URL</label>
							</div>
							<div class="col-md-6">
								<p><%=Curso.getURL()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">

								<h4 align="center">Ediciones previas</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getEdiciones().isEmpty()) {

												for (String edicionPrevia : Curso.getEdiciones()) {
									%>

									<tr>
										<td><a href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(edicionPrevia, "UTF-8")%>&NombreCurso=<%=java.net.URLEncoder.encode(Curso.getNombre(), "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=edicionPrevia%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No Tiene
												Edicion previa</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>

						</div>
						<div class="row">
							<div class="col-md-6">
								<h4 align="center">Cursos Previa</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getPrevias().isEmpty()) {

												for (String previas : Curso.getPrevias()) {
									%>

									<tr>
										<td><a href="CargarDatosDeCurso?nombreCurso=<%=previas%>"
											type="submit" id="linksuscribirme" target="_self"><%=previas%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No tiene
												previas</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<h4 align="center">Programas de formacion que integra</h4>
								<table style="width: 100%">
									<%
										if (!Curso.getProgramas().isEmpty()) {

												for (String programaFormacion : Curso.getProgramas()) {
									%>

									<tr>
										<td><a
											href="CargarDatosDeProgramaDeFormacion?NombrePF=<%=programaFormacion%>"
											type="submit" id="linksuscribirme" target="_self"><%=programaFormacion%></a></td>
									</tr>
									<%
										}
											} else {
									%>
									<tr>
										<td><a id="NoContienePrevias" target="_self">No
												Integra Programa de formacion</a></td>
									</tr>

									<%
										}
									%>

								</table>
							</div>
						</div>
						<hr class="mb-4">
						<div class="col-md-6">
							<button class="btn btn-info"
								onclick="window.location.href = 'Principal';" type="button">Home</button>
						</div>
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<%
							if (request.getAttribute("DatosEdicionActual") != null) {
									DtInstancia edicionVigente = (DtInstancia) request.getAttribute("DatosEdicionActual");
									if (edicionVigente instanceof DtEdicion) {
										DtEdicion ed = (DtEdicion) edicionVigente;
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Cupos</label>
							</div>
							<div class="col-md-6">
								<% if (ed.getCupo()==-1) { %>
								<p>No tiene cupos</p>
								<%} else { %>
								<p> <%=ed.getCupo() %> </p>
								<%} %>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de Inicio</label>
							</div>
							<div class="col-md-6">
								<p>
									<%
										String date1 = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getInicio()));
									%>
								
								<p><%=date1%></p>
								
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de Fin</label>
							</div>
							<div class="col-md-6">
								<p>
									<%
										String date2 = u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFin()));
									%>
								
								<p><%=date2%></p>
							
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Fecha de publicacion</label>
							</div>
							<div class="col-md-6">
								<p>
									<%
									int d1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFechaPublicacion()).get(Calendar.DAY_OF_MONTH);
									int m1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFechaPublicacion()).get(Calendar.MONTH);
									m1=m1+1;
									int y1=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(ed.getFechaPublicacion()).get(Calendar.YEAR);
									String date3 = Integer.toString(d1) + '/'
												+ Integer.toString(m1) + '/'
												+ Integer.toString(y1);
										
									%>
								
								<p><%=date3%></p>
								
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="docentes">Docentes de la edicion</label> <select
									class="custom-select d-block w-100" id="docentes" required>
									<%
										if (!ed.getDocentesParticipan().isEmpty()) {

														for (String docente : ed.getDocentesParticipan()) {
									%>
									<option><%=docente%></option>
									<%
										}
									%>
								</select>
								<%
									} else {
								%><div class="row">
									<p>No tiene docentes</p>
								</div>
								<%
									}
								%>
							</div>

						</div>
						<hr class="mb-4">
						<div class="row">
							<hr class="mb-4">
							<div class="row">
								<div class="col-md-6">
								<%
									String cursito=Curso.getNombre();
								
								
									String scooby="Suscribirme";
									String papa="f";
									if (request.getAttribute("mod")!= null) {
										scooby="Modificar Suscripcion";
										papa="t";
									}
								
									if (!ed.isBorrarBoton()) {
								%>
								<button class="open-button" onclick="openForm()"><%=scooby %></button>
								<%} %>
								
								
								
								
								<div class="form-popup" id="myForm">
  								<form action="altaDe?Tipo=suscribirPF&edi=<%=java.net.URLEncoder.encode(ed.getNombre(), "UTF-8") %>&flag=<%=papa %>&curso=<%=java.net.URLEncoder.encode(cursito, "UTF-8") %>" class="form-container" method="post" novalidate>
    							<h1><%=scooby %></h1>

    							<label for="psw"><b>URL video</b></label>
   								<input type="text" placeholder="Ingresar URL" name="psw"  >

    							<button type="submit" class="btn btn-primary btn-lg btn-block"><%=scooby %></button>
    							<button type="button" class="btn cancel" onclick="closeForm()">Cerrar</button>
  								</form>
								</div>
								</div>
							</div>
							<%
							}
						%>
							<%
							} else {
						%>
						<table style="width: 100%">
							<tr>
								<td><a id="NoContienePrevias" target="_self">No Tiene
										Edicion Previa</a></td>
							</tr>
							</table>
							<%
							}
						%>
						</div>
					</div>
				</div>
			</div>
			</div>
	
</div>
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>

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

