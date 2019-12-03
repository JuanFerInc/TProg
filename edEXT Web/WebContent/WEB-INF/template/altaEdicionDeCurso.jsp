<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="media/imagenes/logo7.jpg" alt=""
				width="72" height="72">
			<h2>Alta de edicion de curso</h2>
			<p class="lead">¡Registra una edicion de curso!</p>
			<%
			if(request.getAttribute("errorRegistrar")!= null){
				%>
				
				 <font color="red"><%=request.getAttribute("errorRegistrar") %></font>
				
				
				<%
				
			}
			%>
		</div>
		<div class="row">
			<div class="col-md-12 order-md-1">
				<h4 class="mb-3">Registro</h4>
				<form action="altaDe?Tipo=AltaEdicion" class="needs-validation" method="Post" novalidate>
					<div class="row">
					  <div class="col-md-6 mb-3">
            <label for="insti">Nombre del instituto del curso.</label>
            <select class="custom-select d-block w-100" id="insti" name="insti" required>
              <option><%=(String)session.getAttribute("Instituto") %></option>

            </select>
            <div class="invalid-feedback">
              No puede dejar el campo Instituto en blanco.
            </div>
          </div>
					</div>
					<div class="row">
					  <div class="col-md-6 mb-3">
            <label for="curso">Nombre del curso.</label>
            <select class="custom-select d-block w-100" id="curso" name="curso" required>
              <option><%=(String)request.getAttribute("cursito") %></option>

            </select>
            <div class="invalid-feedback">
              No puede dejar el campo curso en blanco.
            </div>
          </div>
					</div>

					<div class="mb-3">
						<label for="nombre">Nombre de la edicion de curso</label>
						<div class="input-group">
							<div class="input-group-prepend"></div>
							<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de edicion de curso" required>
							<div class="invalid-feedback" style="width: 100%;">Es
								necesario ingresar un nombre de edicion de curso.</div>
						</div>
					</div>
					<div class="mb-3">
						<label id="imagenURL">URL de la Imagen de la Edicion del
							Curso</label>
						<div class="input-group">
							<div class="input-group-prepend"></div>
							<input type="text" class="form-control" id="imagenURL" name="imagenURL" placeholder="Nombre de edicion de curso">
						</div>
					</div>
					
					<div class="mb-3">
							cupos : <input type="number" class="form-control" name="cupos" min="1" max="10000" >
  								<div class="invalid-feedback">
            					Por favor ingresa un cupo valido.
          					</div>
						
					</div>
					<div class="mb-3">
						<input type="checkbox" name="cuposcheck" value="siuuu"> seleccione para que la edicion tenga cupos<br>
					</div>
					<div>
					<hr class="mb-4">
					</div>
					<div class="row">
						<div class="col-md-6 mb-3">
						<p>Fecha de inicio</p>
							<div class="col-md-12 mb-3">
  								Dia : <input type="number" class="form-control" name="dia" min="1" max="31" required>
  								<div class="invalid-feedback">
            					Por favor ingresa un dia valido.
          					</div>
  						</div>
 						<div class="col-md-12 mb-3">
 							Mes: <input type="number" class="form-control" name="mes" min="1" max="12" required>
 							<div class="invalid-feedback">
            				Por favor ingresa un mes valido.
          				</div>
 					</div>
  					<div class="col-md-12 mb-3">
  						Año: <input type="number" class="form-control" name="anio" min="1" max="3000" required>
  						<div class="invalid-feedback">
            				Por favor ingresa un año valido.
          				</div>
  					</div>
						</div>
						<div class="col-md-6 mb-3">
							<p>Fecha de finalizacion</p>
							<div class="col-md-12 mb-3">
  								Dia : <input type="number" class="form-control" name="diaf" min="1" max="31" required>
  								<div class="invalid-feedback">
            					Por favor ingresa un dia valido.
          					</div>
  						</div>
 						<div class="col-md-12 mb-3">
 							Mes: <input type="number" class="form-control" name="mesf" min="1" max="12" required>
 							<div class="invalid-feedback">
            				Por favor ingresa un mes valido.
          				</div>
 					</div>
  					<div class="col-md-12 mb-3">
  						Año: <input type="number" class="form-control" name="aniof" min="1" max="3000" required>
  						<div class="invalid-feedback">
            				Por favor ingresa un año valido.
          				</div>
  					</div>
						</div>
					</div>
					<hr class="mb-4">
						<div class="row">
						   <% Set<String> doc =(Set<String>)request.getAttribute("docs");  %>
          					<div class="row">
								<p>Docentes</p>
								<select name="docentes" multiple>
  								<% for (String i : doc) {
              
              					%>
              					<option value="<%=i%>"><%=i %></option>
             					<%
              					}
              					%>
								</select>
							</div>
						</div>

					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Dar de Alta</button>
				</form>
				<hr class="mb-4">
				<div class="row">
					<div class="col-md-6">
						<a href="Principal" type="submit" class="btn btn-info"
							target="_self" role="button">Home</a>
					</div>
				</div>
			</div>
		</div>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2019-2019 EdExt</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacidad</a></li>
				<li class="list-inline-item"><a href="#">Términos</a></li>
				<li class="list-inline-item"><a href="#">Ayuda</a></li>
			</ul>
		</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
	<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script src="form-validation.js"></script>
</body>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<script src="../../assets/js/vendor/holder.min.js"></script>
<script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>