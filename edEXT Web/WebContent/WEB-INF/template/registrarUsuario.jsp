<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>


<%Set<String> tito=(Set<String>)request.getAttribute("institutos"); %>

  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="media/imagenes/logo7.jpg" alt="" width="72" height="72">
    <h2>Formulario de registro</h2>
    <p class="lead">Regístrate a EdExt para estar al tanto de las novedades de la extensión educativa de nuestro país ¡Es gratis!</p>
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
      <form action="altaDe?Tipo=AltaUsuario"class="needs-validation" method="Post" novalidate>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">Nombres</label>
            <input type="text" class="form-control" name="firstName" placeholder="" value="" required>
            <div class="invalid-feedback">
              No puede dejar el campo nombre en blanco.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Apellidos</label>
            <input type="text" class="form-control" name="lastName" placeholder="" value="" required>
            <div class="invalid-feedback">
              No puede dejar el campo apellido en blanco.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="username">Nombre de Usuario</label>
          <div class="input-group">
            <input type="text" class="form-control" name="username" placeholder="Nombre de usuario" required>
            <div class="invalid-feedback" style="width: 100%;">
              Es necesario ingresar un nombre de usuario.
            </div>
          </div>
        </div>
        <div class="mb-3">
          <label for="email">Email   <!-- <span class="text-muted">(Optional)</span> --></label>
          <input type="email" class="form-control" name="email" placeholder="nombre@ejemplo.edu.uy" required>
          <div class="invalid-feedback">
            Por favor ingresa un email válido.
          </div>
        </div >
        <div>
        <p>Fecha de nacimiento</p>
        </div>
         <div class="mb-3"> 
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
           <div class="mb-3">
          <label for="pas">Contraseña   <!-- <span class="text-muted">(Optional)</span> --></label>
          <input type="password" class="form-control" name="pas" placeholder="" required>
          <div class="invalid-feedback">
            Por favor ingresa un password válido.
          </div>
        </div>
            <div class="mb-3">
          <label for="pas">Confirmacion  <!-- <span class="text-muted">(Optional)</span> --></label>
          <input type="password" class="form-control" name="pascon" placeholder="" required>
          <div class="invalid-feedback">
            Por favor ingresa un password válido.
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 mb-3">
            <label for="country">Instituto</label>
            <select class="custom-select d-block w-100" name="instituto" required>
              <% for (String i : tito) {
              
              %>
              <option><%=i %></option>
              <%
              }
              %>
            </select>
            <div class="invalid-feedback">
              Por favor seleccione un instituto válido
            </div>
          </div>
        </div>
             <div class="mb-3">
            <label for="lastName">URL imagen</label>
            <input type="text" class="form-control" name="urlimagen" placeholder="" value="" >
          </div>
        <hr class="mb-4">
        <div class="custom-control custom-checkbox">
         <input type="checkbox" name="docente" value="docente"> Soy docente<br>
        </div>
      
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Registrar</button>
      </form>
             <hr class="mb-4">
       <div class="row">
       <div class="col-md-6">
       <a href="Principal"  class="btn btn-info"  target="_self" role="button">Home</a>
       </div>
       </div>
    </div>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2019-2019 EdExt</p>
  </footer>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="form-validation.js"></script></body>
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