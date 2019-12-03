<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.edEXT.TipoSession"%>



<%
	Map<String, String> resultado = (Map<String, String>) request.getAttribute("Resultado");
	List<String> ayuda = (List<String>)request.getAttribute("Ayuda");
	if(ayuda == null){
		
		
		for (Map.Entry<String, String> iter : resultado.entrySet()) {
	%>
	<!-- div class col-7  es necesario para que se mantengan en forma las cajitas-->
	
	<div class="col-xl col-md-12 mb-4">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div class="h5 mb-0 font-weight-bold text-gray-800"><%=iter.getKey()%>
						</div>
						<div class="text-right">
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Opciones</button>
								<div class="dropdown-menu dropdown-menu-right">
									
										<%if (iter.getValue().compareTo("Programa") == 0) {%>
										<button class="dropdown-item" onclick="window.location.href = 'CargarDatosDeProgramaDeFormacion?NombrePF=<%=java.net.URLEncoder.encode(iter.getKey(), "UTF-8")%>';"
										type="button">Ver Datos</button>
									<%
										} else {
									%>
										<button class="dropdown-item" onclick="window.location.href = 'CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(iter.getKey(), "UTF-8")%>';"
										type="button">Ver Datos</button>
								
									<%
										}
									%>
	
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
	}else{
	
		
		for (int i = 0;i < ayuda.size(); i++) {
	%>
	<!-- div class col-7  es necesario para que se mantengan en forma las cajitas-->
	
	<div class="col-xl col-md-12 mb-4">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div class="h5 mb-0 font-weight-bold text-gray-800"><%=ayuda.get(i) %>
						</div>
						<div class="text-right">
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Opciones</button>
								<div class="dropdown-menu dropdown-menu-right">
									
										<%if (resultado.get(ayuda.get(i)).compareTo("Programa") == 0) {%>
										<button class="dropdown-item" onclick="window.location.href = 'CargarDatosDeProgramaDeFormacion?NombrePF=<%=java.net.URLEncoder.encode(ayuda.get(i), "UTF-8")%>';"
										type="button">Ver Datos</button>
									<%
										} else {
									%>
										<button class="dropdown-item" onclick="window.location.href = 'CargarDatosDeCurso?nombreCurso=<%=java.net.URLEncoder.encode(ayuda.get(i), "UTF-8")%>';"
										type="button">Ver Datos</button>
								
									<%
										}
									%>
	
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

<div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h8 mb-0 font-weight-bold text-gray-800"><%=resultado.size() %> Resultados
					</div>
					<div class="text-right">
						<div class="btn-group">
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Opciones</button>
							<div class="dropdown-menu dropdown-menu-right">
				
									<button class="dropdown-item" onclick="window.location.href = 'TuNombreEs?MMMMMMOOOOOOOOOOOOONICA=<%=request.getAttribute("Buscaste")%>&FormaBuscqueda=FiltrarCurso';"
									type="button">Filtrar por Curso</button>
							
									<button class="dropdown-item" onclick="window.location.href = 'TuNombreEs?MMMMMMOOOOOOOOOOOOONICA=<%=request.getAttribute("Buscaste")%>&FormaBuscqueda=FiltrarPrograma';"
									type="button">Filtrar por Programa de Formacion</button>
									
									<button class="dropdown-item" onclick="window.location.href = 'TuNombreEs?MMMMMMOOOOOOOOOOOOONICA=<%=request.getAttribute("Buscaste")%>&FormaBuscqueda=Alfa';"
									type="button">Ordenar Alfabeticamente(A-Z)</button>
							
										<button class="dropdown-item" onclick="window.location.href = 'TuNombreEs?MMMMMMOOOOOOOOOOOOONICA=<%=request.getAttribute("Buscaste")%>&FormaBuscqueda=Fecha';"
									type="button">Ordenar por Fecha de Publicacion(Nuevo-Viejo)</button>
						
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
