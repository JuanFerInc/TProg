<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="publicador.DtCurso"%>
<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceUsuario"%>
<%@page import="java.util.Calendar"%>
<%@page import="publicador.DtInstancia"%>
<%@page import="publicador.DtEdicion"%>


<%
	DtCurso Curso = (DtCurso) request.getAttribute("DatosCurso");

	String imagenURL = "media/imagenes/programadeformacion1.jpg";
	if (Curso.getImagen().compareTo("--") != 0) {
		imagenURL = Curso.getImagen();
	}
%>

<%
	if(request.getAttribute("error")!= null){
%>
				
<font color="red"><%=request.getAttribute("error") %></font>
				
				
<%
}
%>

	<div class="profile-img">
		<img src="<%=imagenURL%>" alt="Foto de perfil" style="width: 100%; height: 100%;" />
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Nombre del curso :</b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=Curso.getNombre()%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Descripcion :</b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=Curso.getDescripcion()%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Creditos: </b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=Curso.getCreditos()%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Duracion: </b></h5>
	</div>						
	<div>
		<p style="margin-left:3em"><%=Curso.getDuracion()%> Semanas</p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Horas: </b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=Curso.getHoras()%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Fecha de registro: </b></h5>
	</div>
	<div>
		<%
			interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
			int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.DAY_OF_MONTH);
			int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.MONTH);
			m=m+1;
			int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(Curso.getFechaRegistrado()).get(Calendar.YEAR);
			String date = Integer.toString(d) + '/'
			+ Integer.toString(m) + '/'
			+ Integer.toString(y);
		%>
		<p style="margin-left:3em"><%=date%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>URL: </b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=Curso.getURL()%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Edicion vigente</b></h5>
	</div>
		<%
			if (request.getAttribute("DatosEdicionActual") != null) {
				DtInstancia edicionVigente = (DtInstancia) request.getAttribute("DatosEdicionActual");
				if (edicionVigente instanceof DtEdicion) {
					DtEdicion ed = (DtEdicion) edicionVigente;
		%>
	<div>
		<a style="margin-left:3em" href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(ed.getNombre(), "UTF-8")%>&NombreCurso=<%=java.net.URLEncoder.encode(Fabrica.getInstancia().getICurso().dameNombreCurso(ed.getNombre()), "UTF-8")%>"
			type="submit" id="linksuscribirme" target="_self"><%=ed.getNombre()%></a>
	</div>
		<%
				}
			}else{
		%>
	<div>
		<p style="margin-left:3em">No tiene edicion vigente</p>
	</div>
		<%
			}
		%>
	<div>
		<h5 style="margin-left:1em"><b>Ediciones viejas</b></h5>
	</div>
			<%
				if (!Curso.getEdiciones().isEmpty()) {
					for (String edicionPrevia : Curso.getEdiciones()) {
			%>
	<div>
		<a style="margin-left:3em" href="EdicionPrevia?Nombre=<%=java.net.URLEncoder.encode(edicionPrevia, "UTF-8")%>&NombreCurso=<%=java.net.URLEncoder.encode(Fabrica.getInstancia().getICurso().dameNombreCurso(edicionPrevia), "UTF-8")%>"
			type="submit" id="linksuscribirme" target="_self"><%=edicionPrevia%></a>
	</div>					
			<%
				}
			} else {
			%>
	<div>
		<p style="margin-left:3em">No tiene ediciones viejas</p>
	</div>
			<%
			}
			%>
			
	<div>
		<h5 style="margin-left:1em"><b>Cursos previos</b></h5>
	</div>
		<%
			if (!Curso.getPrevias().isEmpty()) {
				for (String previas : Curso.getPrevias()) {
		%>
	<div>
		<a style="margin-left:3em" href="CargarDatosDeCursoMobile?nombreCurso=<%=java.net.URLEncoder.encode(previas, "UTF-8")%>"
		type="submit" id="linksuscribirme" target="_self"><%=previas%></a>
	</div>
		<%
			}
			} else {
		%>
	<div>
		<p style="margin-left:3em">No tiene cursos previos</p>
	</div>
		<%
			}
		%>
	<div>
		<h5 style="margin-left:1em"><b>Programas de Formacion que integra</b></h5>
	</div>						
		<%
			if (!Curso.getProgramas().isEmpty()) {
				for (String programaFormacion : Curso.getProgramas()) {
		%>
	<div>
		<p style="margin-left:3em"><%=programaFormacion%></p>
	</div>
		<%
			}
			} else {
		%>
	<div>
		<p style="margin-left:3em">No integra ningun programa de formacion</p>
	</div>
		<%
			}
		%>

	
		