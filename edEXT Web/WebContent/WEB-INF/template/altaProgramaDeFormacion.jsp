<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Registro a EdExt</title>

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
    <h2>Crear programa de formacion</h2>
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
      <form action="altaDe?Tipo=AltaPF" class="needs-validation" method="Post" novalidate>
         <div class="mb-3">
          <label for="nombre">Nombre del programa de formacion</label>
          <div class="input-group">
            <div class="input-group-prepend">
            </div>
            <input type="text" name="nombrePF" class="form-control" id="nombre" placeholder="" required>
            <div class="invalid-feedback" style="width: 100%;">
              Es necesario ingresar un nombre de programa de formacion.
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
          <p>Fecha de Inicio</p>
              <div class="mb-3"> 
  			<div class="col-md-12 mb-3">
  				Dia : <input type="number" class="form-control" name="diai" min="1" max="31" required>
  				<div class="invalid-feedback">
            	Por favor ingresa un dia valido.
          		</div>
  			</div>
 			<div class="col-md-12 mb-3">
 				Mes: <input type="number" class="form-control" name="mesi" min="1" max="12" required>
 				<div class="invalid-feedback">
            	Por favor ingresa un mes valido.
          		</div>
 			</div>
  			<div class="col-md-12 mb-3">
  				Año: <input type="number" class="form-control" name="anioi" min="1" max="3000" required>
  				<div class="invalid-feedback">
            	Por favor ingresa un año valido.
          		</div>
  			</div>
		</div>
          </div>
          <div class="col-md-6 mb-3">
           <p>Fecha de Finalizacion</p>
              <div class="mb-3"> 
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
        </div>
        

        <div class="mb-3">
          <label for="username">Descripcion</label>
          <div class="input-group">
            <div class="input-group-prepend">
            </div>
            <input type="text" name="descripcionPF" class="form-control" id="username" placeholder="" required>
            <div class="invalid-feedback" style="width: 100%;">
              Es necesario ingresar una descripcion.
            </div>
          </div>
        </div>
        
        
          <div class="mb-3">
            <label for="lastName">URL imagen</label>
            <input type="text" class="form-control" name="urlimagenPF" placeholder="" value="" >
          </div>
          
          
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Registrar</button>
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