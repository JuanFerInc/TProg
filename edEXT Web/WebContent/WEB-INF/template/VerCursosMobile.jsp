<%@page import="java.util.List"%>
 <!-- INSTITUTOS -->
  <%
  List<String> Institutos = (List<String>)request.getAttribute("ListaInstitutos");
	for (String i : Institutos) {
  %>
 <div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=i%>
					</div>
					<div class="text-right">
						<div class="dropdown show">
		 					<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    
  							</a>

  							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    							<a class="dropdown-item" href="CargarCursosMobile?arg1=Instituto&arg2=<%=i %>">Ver Cursos</a>
  							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
  <%} %>
  <!-- CATEGORIAS -->
    <%
  List<String> Categorias = (List<String>)request.getAttribute("ListaCategorias");
	for (String i : Categorias) {
  %>
 <div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=i%></div>
					<div class="text-right">
						<div class="dropdown show">
		 					<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    
  							</a>

  							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    							<a class="dropdown-item" href="CargarCursosMobile?arg1=Categoria&arg2=<%=i %>">Ver Cursos</a>
  							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</div>
</div>
  <%} %>
  

