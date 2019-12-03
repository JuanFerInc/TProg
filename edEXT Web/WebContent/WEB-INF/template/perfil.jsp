<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceUsuario"%>
<%@page import="com.intermediario.interfaceCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="com.edEXT.TipoSession"%>
<%@page import="publicador.DtUsuario"%>
<%@page import="publicador.DtDocente"%>
<%@page import="publicador.DtEstudianteIn"%>
<%@page import="publicador.DtInstancia"%>
<%@page import="publicador.UsuarioNoExisteExcep_Exception"%>
<%
	DtUsuario usuario = (DtUsuario)request.getAttribute("dtUsuario");
	if(usuario instanceof DtDocente){
		DtDocente dtD = (DtDocente)usuario;
		String imagenURL = "media/imagenes/programadeformacion1.jpg";
		if(dtD.getImagen().compareTo("--") != 0){
			imagenURL = dtD.getImagen();
		}
		
		%>
<body>
	<div class="container emp-profile">
		<form method="post">
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
						<img src=<%=imagenURL %> alt="Foto de perfil"
							style="width: 225px; height: 200px;" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h5>
							<%=dtD.getNombre()%>
							<%=dtD.getApellido()%>
						</h5>
						<h6>Docente</h6>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="home-tab" data-toggle="tab" href="#home" role="tab"
								aria-controls="home" aria-selected="true">General</a></li>
							<li class="nav-item"><a class="nav-link" id="profile-tab"
								data-toggle="tab" href="#profile" role="tab"
								aria-controls="profile" aria-selected="false">Cursos</a></li>
							<li class="nav-item"><a class="nav-link" id="seguidores-tab"
								data-toggle="tab" href="#seguidores" role="tab"
								aria-controls="seguidores" aria-selected="false">Seguidores</a></li>
							<li class="nav-item"><a class="nav-link" id="seguidos-tab"
								data-toggle="tab" href="#seguidos" role="tab"
								aria-controls="seguidos" aria-selected="false">Seguidos</a></li>

						</ul>
					</div>
				</div>
				<%
                    String nickelodeon = (String)session.getAttribute("nick_usuario");
                    String nick = dtD.getNick();
                    if(nick.equals(nickelodeon)){
                    %>
				<div class="col-md-2">
					<button class="btn btn-info"
						onclick="window.location.href = 'inicioDe?Tipo=Editar&Nick=<%=java.net.URLEncoder.encode(nick, "UTF-8") %>';"
						type="button">Editar Perfil</button>
				</div>

				<%
                    } 
                    %>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="profile-work"></div>
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
									<p><%=dtD.getNick()%></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Nombre</label>
								</div>
								<div class="col-md-6">
									<p><%=dtD.getNombre()%>
										<%=dtD.getApellido()%></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<p><%=dtD.getCorreo()%></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Fecha de nacimiento</label>
								</div>
								<div class="col-md-6">
									<%
									interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
									String s=IUsuario.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(dtD.getFechaNacimiento()));
							%>
									<p><%= s %></p>
								</div>
							</div>
							<hr class="mb-4">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
							
							<%
							if(!(session.getAttribute("estado_sesion") == TipoSession.NO_LOGIN)){
							String nicko = (String)session.getAttribute("nick_usuario");
							if((nicko != dtD.getNick()) && !(dtD.getSeguidores().contains(nicko))){
							%>
							
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'seguidores?seguir=<%="true"%>&desde=<%=nicko %>&hasta=<%=dtD.getNick() %> ';" type="button">Seguir</button>
							</div>
							<%
							}
							%>
							<%if((nicko != dtD.getNick()) && (dtD.getSeguidores().contains(nicko))){
							%>
							
							<div class="col-md-6">
								<a class="btn btn-info"
									href = "seguidores?seguir=<%="false"%>&desde=<%=nicko %>&hasta=<%=dtD.getNick() %>" type="button">Dejar de Seguir</a>
							</div>
							<%
							}
							}
							%>
							
						</div>
						<div class="tab-pane fade" id="profile" role="tabpanel"
							aria-labelledby="profile-tab">
							<div class="row">

								<label for="ediciones">Ediciones de cursos asociadas </label>
								<%
            									Set<String> setsito = new HashSet<String>();
                                               	for (DtInstancia j : dtD.getDatosEdicionesIntegra()){
                                               		setsito.add(j.getNombre());
                                               	}
                                               	List<String> ediciones = new ArrayList<>(setsito);
            									for (String i : ediciones) { 
            									%>
								<table style="width: 100%">
									<tr>
										<td><a
											href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(i, "UTF-8")%>&NombreCurso=<%=java.net.URLEncoder.encode(Fabrica.getInstancia().getICurso().dameNombreCurso(i), "UTF-8")%>"
											type="submit" id="linksuscribirme" target="_self"><%=i %></a></td>
									</tr>

									<%
  												}
            									%>
								</table>
							</div>
							<hr class="mb-4">
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'Principal';" type="button">Home</button>
							</div>
						</div>
						<div class="tab-pane fade" id="seguidores" role="tabpanel"
							aria-labelledby="seguidores-tab">
							<table style="width: 100%">
								<%
                            	Set<String> seton = new HashSet<String>(dtD.getSeguidores());
                            	for(String i: seton) {
                    			%>
								<tr>
									<td><a
										href="Perfil?nick=<%=java.net.URLEncoder.encode(i, "UTF-8") %>"
										type="submit" id="linksuscribirme" target="_self"><%=i %></a>
									</td>

								</tr>
								<%
                            	}
  								%>
							</table>

						</div>
						<div class="tab-pane fade" id="seguidos" role="tabpanel"
							aria-labelledby="seguidos-tab">
							<table style="width: 100%">
								<%
                            	Set<String> setoncito = new HashSet<String>(dtD.getSeguidos());
                            	for(String i: setoncito) {
                    			%>
								<tr>
									<td><a
										href="Perfil?nick=<%=java.net.URLEncoder.encode(i, "UTF-8") %>"
										type="submit" id="linksuscribirme" target="_self"><%=i %></a>
									</td>

								</tr>
								<%
                            	}
  								%>
							</table>

						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
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
</body>

<%}else if(usuario instanceof DtEstudianteIn){
			DtEstudianteIn dtE = (DtEstudianteIn)usuario;
			String imagenURL = "media/imagenes/programadeformacion1.jpg";
			if(dtE.getImagen().compareTo("--") != 0){
				imagenURL = dtE.getImagen();
			}
		
		%>

<body>
	<%
			if(request.getAttribute("error")!= null){
				%>

	<font color="red"><%=request.getAttribute("error") %></font>


	<%
				
			}
			%>
	<div class="container emp-profile">
		<form method="post">
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
						<img src=<%=imagenURL%> alt="Foto de perfil"
							style="width: 225px; height: 200px;" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h5>
							<%=dtE.getNombre()%>
							<%=dtE.getApellido()%>
						</h5>
						<h6>Estudiante</h6>
						<%
						 String nickelodeon = (String)session.getAttribute("nick_usuario");
	                    String nick = dtE.getNick();
						%>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="home-tab" data-toggle="tab" href="#home" role="tab"
								aria-controls="home" aria-selected="true">General</a></li>
							<li class="nav-item"><a class="nav-link"
								id="inscripciones-tab" data-toggle="tab" href="#inscripciones"
								role="tab" aria-controls="inscripciones" aria-selected="false">Inscripciones</a></li>
							<%  if(nick.equals(nickelodeon)){ %>
							<li class="nav-item"><a class="nav-link" id="notas-tab"
								data-toggle="tab" href="#notases" role="tab"
								aria-controls="notases" aria-selected="false">Notas</a></li>
							<%} %>
							<li class="nav-item"><a class="nav-link" id="seguidores-tab"
								data-toggle="tab" href="#seguidores" role="tab"
								aria-controls="seguidores" aria-selected="false">Seguidores</a></li>
							<li class="nav-item"><a class="nav-link" id="seguidos-tab"
								data-toggle="tab" href="#seguidos" role="tab"
								aria-controls="seguidos" aria-selected="false">Seguidos</a></li>

						</ul>
					</div>
				</div>
				<%
                   
                    if(nick.equals(nickelodeon)){
                    %>
				<div class="col-md-2">
					<button class="btn btn-info"
						onclick="window.location.href = 'inicioDe?Tipo=Editar&Nick=<%=java.net.URLEncoder.encode(nick, "UTF-8") %>';"
						type="button">Editar Perfil</button>
				</div>

				<%
                    } 
                    %>
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
									<p><%=dtE.getNick()%></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Nombre</label>
								</div>
								<div class="col-md-6">
									<p><%=dtE.getNombre()%>
										<%=dtE.getApellido()%></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<p><%=dtE.getCorreo()%></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Fecha de nacimiento</label>
								</div>
								<div class="col-md-6">
									<%
					//tito
					//ctrlz
									interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
									String datefin=IUsuario.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(dtE.getFechaNacimiento()));
							%>
									<p><%= datefin %></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label for="Programas">Programas de Formacion</label>
									<table style="width: 100%">
										<%
										List<String> programas = new ArrayList<>(dtE.getSetProgramas());
                                                if(programas.isEmpty()){
                                                %>
										<tr>
											<td><a>No hay programas</a></td>
										</tr>
										<%}else{
            									for (String i : programas) { 
            									%>
										<tr>
											<td><a
												href="CargarDatosDeProgramaDeFormacion?NombrePF=<%=java.net.URLEncoder.encode(i, "UTF-8") %>"
												type="submit" id="linksuscribirme" target="_self"><%=i %></a>
											</td>
										</tr>

										<%
  												}
                           						}
            									%>

									</table>
								</div>
							</div>
							<hr class="mb-4">
							<div class="row">
								<div class="col-md-6">
									<a href="Principal" type="submit" class="btn btn-info"
										id="linksuscribirme" target="_self" role="button">Home</a>
								</div>
								
								
							<%
							if(!(session.getAttribute("estado_sesion")== TipoSession.NO_LOGIN)){
							String nicko = (String)session.getAttribute("nick_usuario");
							if((nicko != dtE.getNick()) && !(dtE.getSeguidores().contains(nicko))){
							%>
							
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'seguidores?seguir=<%="true"%>&desde=<%=nicko %>&hasta=<%=dtE.getNick() %>';" type="button">Seguir</button>
							</div>
							<%
							}
							%>
							<%if((nicko != dtE.getNick()) && (dtE.getSeguidores().contains(nicko))){
							%>
							
							<div class="col-md-6">
								<button class="btn btn-info"
									onclick="window.location.href = 'seguidores?seguir=<%="false"%>&desde=<%=nicko %>&hasta=<%=dtE.getNick() %>';" type="button">Dejar de Seguir</button>
							</div>
							<%
							}
							}
							%>
								
							</div>
						</div>
						<div class="tab-pane fade" id="inscripciones" role="tabpanel"
							aria-labelledby="inscripciones-tab">
							<div class="row">
								<p align="center">Estado de Inscripciones a ediciones de
									cursos</p>
							</div>
							<%
							String nickel = (String)session.getAttribute("nick_usuario");
                			String nicke = dtE.getNick();
							%>
							<table style="width: 100%">
								<tr>
									<th>Edicion de curso</th>
									<th>Estado</th>
									<%if(nicke.equals(nickel)){ %>
									<th>Desistir</th>
									<%} %>
								</tr>
								<%
                            	
                            	
                            	Map<String,Map<Calendar,String>> mapita = (Map<String,Map<Calendar,String>>)interfaceUsuario.toMapStringMapCalendarString(dtE.getMapEdiciones());
                            	for(Map.Entry<String,Map<Calendar,String>> i: mapita.entrySet()) {
                    				for(Map.Entry<Calendar,String> j: i.getValue().entrySet()){
                    					if(nicke.equals(nickel)){
                    			%>
								<tr>
									<td><a
										href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(i.getKey(), "UTF-8") %>&NombreCurso=<%=java.net.URLEncoder.encode(Fabrica.getInstancia().getICurso().dameNombreCurso(i.getKey()), "UTF-8")%>"
										type="submit" id="linksuscribirme" target="_self"><%=i.getKey() %></a>
									</td>
									<td><%=j.getValue()%></td>
									<% if (j.getValue().equals("Inscripto")) { 
									%>
									<td><a
										href="altaDe?Tipo=desistir&NombreCurso=<%=java.net.URLEncoder.encode(i.getKey(), "UTF-8") %>"
										type="submit" target="_self" role="button"
										class="btn btn-info">Desistir</a></td>
									<% 	
									} else { 
									%>
									<td>-</td>
									<% 	
									}
									%>
								</tr>
								<%}else if(! j.getValue().equals("Rechazada")){%>
								<tr>
									<td><a
										href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(i.getKey(), "UTF-8") %>&NombreCurso=<%=java.net.URLEncoder.encode(Fabrica.getInstancia().getICurso().dameNombreCurso(i.getKey()), "UTF-8")%>"
										type="submit" id="linksuscribirme" target="_self"><%=i.getKey() %></a></td>
									<td><%=j.getValue()%></td>
								</tr>
								<%
  								}
                            	}
                            	}
  								%>
							</table>
							<hr class="mb-4">
							<div class="row">
								<div class="col-md-6">
									<a href="Principal" type="submit" class="btn btn-info"
										target="_self" role="button">Home</a>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="notases" role="tabpanel"
							aria-labelledby="notas-tab">
							<table style="width: 100%">
								<tr>
									<th>Nick</th>
									<th>Nota</th>
								</tr>
								<% 
 							int pedro;
 							String yo=dtE.getNick();
 							interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
 							Map<String,Map<Calendar,String>> mapita2 = (Map<String,Map<Calendar,String>>)interfaceUsuario.toMapStringMapCalendarString(dtE.getMapEdiciones());
                            	for(Map.Entry<String,Map<Calendar,String>> i: mapita2.entrySet()) {
                    				for(Map.Entry<Calendar,String> j: i.getValue().entrySet()){
                    					if (ICurso.estaCerradaLaEdicion( i.getKey())) {
                    				%>
								<tr>
									<td><%=i.getKey() %></td>
									<%
    								try{
    								pedro=ICurso.verCorreccion(i.getKey(), yo, false);
    								}catch (UsuarioNoExisteExcep_Exception eddy){
    									pedro=-1;
    								}
    							if (pedro!=-1) {
    								%>
									<td><%=pedro %></td>
									<%} else { %>
									<td>S/N</td>
									<%} %>
									<%}}} %>
								</tr>
							</table>
						</div>
						<div class="tab-pane fade" id="seguidores" role="tabpanel"
							aria-labelledby="seguidores-tab">
							<table style="width: 100%">
								<%
                            	Set<String> seton = new HashSet<String>(dtE.getSeguidores());
                            	for(String i: seton) {
                    			%>
								<tr>
									<td><a
										href="Perfil?nick=<%=java.net.URLEncoder.encode(i, "UTF-8") %>"
										type="submit" id="linksuscribirme" target="_self"><%=i %></a>
									</td>

								</tr>
								<%
                            	}
  								%>
							</table>

						</div>
						<div class="tab-pane fade" id="seguidos" role="tabpanel"
							aria-labelledby="seguidos-tab">
							<table style="width: 100%">
								<%
                            	Set<String> setoncito = new HashSet<String>(dtE.getSeguidos());
                            	for(String i: setoncito) {
                    			%>
								<tr>
									<td><a
										href="Perfil?nick=<%=java.net.URLEncoder.encode(i, "UTF-8") %>"
										type="submit" id="linksuscribirme" target="_self"><%=i %></a>
									</td>

								</tr>
								<%
                            	}
  								%>
							</table>

						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
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
</body>
<%
}

%>