<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Registro de cursos en EdExt</title>

   <!-- <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/"> -->

    <!-- Bootstrap core CSS -->
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="media/imagenes/logo7.jpg" alt="" width="72" height="72">
    <h2>Formulario de registro</h2>
    <p class="lead">Registre un curso</p>
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
      <form action="altaDe?Tipo=AltaCurso" class="needs-validation" method="Post" novalidate>
        <div class="row">
        <% String tito=(String)session.getAttribute("Instituto"); %>
          <div class="col-md-6 mb-3">
            <label for="Instituto">Nombre del instituto del curso.</label>
            <select class="custom-select d-block w-100" id="Instituto" name="insti" required>
              <option><%=tito %></option>

            </select>
            <div class="invalid-feedback">
              No puede dejar el campo Instituto en blanco.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="curso">Nombre del curso.</label>
            <input type="text" class="form-control" id="curso" name="nombrecurso" placeholder="" value="" required>
            <div class="invalid-feedback">
              No puede dejar el campo Nombre en blanco.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="descripcion">Ingrese una descripcion para el curso.</label>
          <div class="input-group">
            <input type="text" class="form-control" id="descripcion" name="dess" placeholder="Descripcion" required>
            <div class="invalid-feedback" style="width: 100%;">
              Es necesario ingresar una descripcion al curso.
            </div>
          </div>
        </div>
        <div class="mb-3">
          <label for="url">URL   <!-- <span class="text-muted">(Optional)</span> --></label>
          <input type="url" class="form-control" id="url" name="urll" placeholder="https://ejemplo.edu.uy" required>
          <div class="invalid-feedback">
            Por favor ingresa una URL válido.
          </div>
        </div>
        
        <div class="row">
        <div class="col-md-6 mb-3">
            <label for="duracion">Duracion</label><span class="text-muted">  (En semanas)</span>
            <input type="number" class="form-control" name="duracion" min="0" max="10000" required>
  				<div class="invalid-feedback">
            	Por favor ingresa un dia valido.
          		</div>
          </div>
          
           <div class="col-md-6 mb-6">
          Cantidad de horas : <input type="number" class="form-control" name="cantHoras" min="0" max="10000" required>
  				<div class="invalid-feedback">
            	Por favor ingresa un dia valido.
          		</div>
          </div>
        </div>
          
          <div class="mb-3">
           Creditos : <input type="number" class="form-control" name="cred" min="0" max="10000" required>
  				<div class="invalid-feedback">
            	Por favor ingrese un numero de creditos  valido.
          		</div>
          </div>
             <div class="mb-3">
           <label for="urlimagen">URL imagen</label>
            <input type="text" class="form-control" id="urlimagen" name="urlimagen" placeholder="" value="" >
          </div>
          <% Set<String> prev =(Set<String>)request.getAttribute("previas");  %>
          <div class="row">
						<p>Previas</p>
						<select name="previas" multiple>
  						<% for (String i : prev) {
              
              			%>
              			<option value="<%=i%>"><%=i %></option>
             			<%
              			}
              			%>
						</select>
			</div>
			
           <hr class="mb-4">
           <% Set<String> cat =(Set<String>)request.getAttribute("categorias");  %>
            <div class="row">
							<p>Categorias</p>
							<select name="categorias" multiple>
  							<% for (String j : cat) {
              
              				%>
              				<option value="<%=j%>"><%=j %></option>
             				<%
              				}
              				%>
							</select>
			</div>
        <div>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Crear curso</button>
        </div>
      </form>
       <hr class="mb-4">
       <div class="row">
       <div class="col-md-6">
       <a href="Principal" type="submit" class="btn btn-info"  target="_self" role="button">Home</a>
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="form-validation.js"></script></body>
</html>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
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
</body>