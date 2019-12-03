<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceCurso"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.edEXT.TipoSession"%>

 <%
  List<String> cu = (List<String>)request.getAttribute("ListaCursos");
 	if(!cu.isEmpty()){
	for (String r : cu) {
  %>
<!-- div class col-7  es necesario para que se mantengan en forma las cajitas-->

<div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=r%>
					</div>
					<div class="text-right">
						<div class="dropdown show">
		 					<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    
  							</a>

  							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    							<a class="dropdown-item" href="CargarDatosDeCursoMobile?nombreCurso=<%=java.net.URLEncoder.encode(r, "UTF-8") %>">Ver Informacion</a>
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
%>
<div>
	<h5 style="margin-left:5em"><b>No hay cursos</b></h5>
</div>
<%} %>
