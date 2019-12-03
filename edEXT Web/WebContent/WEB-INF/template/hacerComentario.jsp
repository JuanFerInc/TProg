<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<%
String nombreEdicion = (String)request.getAttribute("nombreEdicion");
if(request.getAttribute("respondido") != null){
	int respondido = (Integer)request.getAttribute("respondido");

%>
<div>
	<h5>Escriba a continuacion su comentario</h5>
	<form action="hacerComentario?nombreEdicion=<%=nombreEdicion%>&respondido=<%=respondido%>&responder=<%="true"%>"
	 class="needs-validation" method="Post" >
	 <div>
	 	<label for="firstName">Comentario</label>
            <input type="text" class="form-control" name="textirijillo" placeholder="" value="" required>
           	 	<div class="invalid-feedback">
            	  No puede dejar el campo comentario en blanco.
            </div>
	 	</div>
  		<br>
  		<div class="col-mb-6">
  			<button class="btn btn-primary btn-lg btn-block" type="submit">Enviar</button>
  		</div>
	</form>
	<hr class="mb-4">

</div>
<%
}else{
%>
<div>
	<h5>Escriba a continuacion su comentario</h5>
	<form action="hacerComentario?nombreEdicion=<%=nombreEdicion%>&primero=<%="true"%>&responder=<%="false"%>"
	 class="needs-validation" method="Post" >
	 <div>
	 	<label for="firstName">Comentario</label>
            <input type="text" class="form-control" name="textirijillo" placeholder="" value="" required>
           	 	<div class="invalid-feedback">
            	  No puede dejar el campo comentario en blanco.
            </div>
	 	</div>
  		<br>
  		<div class="col-mb-6">
  			<button class="btn btn-primary btn-lg btn-block" type="submit">Enviar</button>
  		</div>
	</form>
	<hr class="mb-4">

</div>



<%
}
%>
