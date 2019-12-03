<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="publicador.DtEdicion"%>
<%@page import="com.intermediario.Fabrica"%>
<%@page import="com.intermediario.interfaceUsuario"%>
<%@page import="java.util.Calendar"%>

	<%	
		DtEdicion edicion = (DtEdicion)request.getAttribute("Edicion");
		String imagenURL = "media/imagenes/programadeformacion1.jpg";
		if(edicion.getFotito().compareTo("--") != 0){
			imagenURL = edicion.getFotito();
		}
	%>
	<div class="profile-img">
		<img src="<%=imagenURL%>" alt="Foto de perfil" style="width: 100%; height: 100%;" />
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Nombre de la Edicion:</b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=edicion.getNombre() %></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Fecha de inicio:</b></h5>
	</div>
		<% 
		interfaceUsuario u=Fabrica.getInstancia().getIUsuario();
		String s=u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getInicio()));
		%>
	<div>
		<p style="margin-left:3em"><%=s%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Fecha de finalizacion:</b></h5>
	</div>
	<div>
		<p style="margin-left:3em"><%=u.fechaDecente(Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFin()))%></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Fecha de publicacion: </b></h5>
	</div>
		<%
			int d=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.DAY_OF_MONTH);
			int m=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.MONTH);
			m=m+1;
			int y=Fabrica.getInstancia().getICurso().fromXMLGregorianCalendar(edicion.getFechaPublicacion()).get(Calendar.YEAR);
			String date = Integer.toString(d) + '/'
			+ Integer.toString(m) + '/'
			+ Integer.toString(y);
		%>
	<div>
		<p style="margin-left:3em"><%=date %></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Cupos: </b></h5>
	</div>
		<%
			String cupos = "No tiene limite";
			if(edicion.getCupo()!= -1){
			cupos = Integer.toString(edicion.getCupo());
			}
		%>
	<div>
		<p style="margin-left:3em"><%=cupos %></p>
	</div>
	<div>
		<h5 style="margin-left:1em"><b>Docentes: </b></h5>
	</div>
	 	<%
			for(String i: edicion.getDocentesParticipan()){								
		%>
	<div>
		<p style="margin-left:3em"><%=i%></p>
	</div>
		<%
			}
		%>
