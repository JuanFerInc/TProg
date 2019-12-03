<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="header" class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="Principal"> <img
			src="media/imagenes/logo7.jpg" alt="logo7" width="35" height="30">
			<span class="" style="font-size: 25px; color: Dodgerblue;"><i
				class=""></i></span> Ed<b>Ext</b>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<!-- <ul class="navbar-nav mr-auto"> -->
			<form class="form-inline my-4 my-lg-0 mr-auto" action="TuNombreEs" method="get">
				<input class="form-control mr-sm-2"
					placeholder="Buscar" aria-label="Buscar" name="MMMMMMOOOOOOOOOOOOONICA"> <input type="submit" value="Buscar" class="btn btn-info"/>
			</form>
			<ul class="navbar-nav">

				<li class="nav-item mr-2">
					<a href="inicioDe?Tipo=Registrar" class="btn btn-info" role="button">Registrar</a>
				</li>

				<li class="nav-item mr-2">
					<a href="inicioDe?Tipo=Session" class="btn btn-info" role="button">Inicio Sesion</a>
				</li>

			</ul>
		</div>
	</nav>
