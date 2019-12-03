<%@page contentType="text/html" pageEncoding="UTF-8"%>

	<nav id="header" class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="dropdown show">
		 	<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    
  			</a>

  			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    			<a class="dropdown-item" href="VerCursosMobile">Ver Cursos</a>
    			<a class="dropdown-item" href="Principal">Salir</a>
  			</div>
		</div>
			
			<%
			String nick = (String)session.getAttribute("nick_usuario");
		%>
			<span class="" style="font-size: 25px; color: Dodgerblue;"><i
				class=""></i></span><b>Bienvenido <%=nick %></b>
		
		
		<a class="navbar-brand" href="LoginMobile"> <img
			src="media/imagenes/logo7.jpg" alt="logo7" width="35" height="30">
		</a>
		
	</nav>
