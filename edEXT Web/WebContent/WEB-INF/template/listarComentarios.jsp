<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicador.DtEdicion"%>
<%@page import="publicador.DtComentario"%>
<%@page import="java.util.List"%>
<%@page import="com.edEXT.TipoSession"%>


<%
 List<DtComentario> comentario = (List<DtComentario>)request.getAttribute("comentario");
	String nombreEdicion = (String)request.getAttribute("nombreEdicion");
if(comentario.isEmpty()){
	
%>
	<h5>No hay comentarios</h5>
<%
}else{
	
	for(DtComentario coment: comentario){	
%>

<div class="col-xl col-md-12 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="h5 mb-0 font-weight-bold text-gray-800"><%=coment.getAutor() %>
					</div>
					<div class="text-left">
					<%
					if(coment.getValoracionDelCurso() == -1){
					%>
					<div>
						<p>No valoro</p>
					</div>
					<%
					}else{
					%>
						<div>
						<p><%=coment.getValoracionDelCurso() %></p>
						</div>
					<%
					}
					%>
					</div>
					<div class="text-right">
						<div>
						<p><%=coment.getTexto() %></p>
						</div>
						<div>
						<%if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE){ %>
							<a href="hacerComentario?nombreEdicion=<%=java.net.URLEncoder.encode(nombreEdicion, "UTF-8") %>&respondido=<%=coment.getId() %>" 
								class="btn btn-info" role="button">Responder</a>
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


<%
	}
}
	if(session.getAttribute("estado_sesion") == TipoSession.LOGIN_ESTUDIANTE){
%>
		<div>
			<a href="hacerComentario?nombreEdicion=<%=java.net.URLEncoder.encode(nombreEdicion, "UTF-8") %>&responder=<%="false" %>" 
				class="btn btn-info" role="button">Comentar Edicion</a>
		</div>
		<hr class="mb-4">
	
<%
}

%>

