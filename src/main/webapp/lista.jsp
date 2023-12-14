<%@page import="alejandro.figueroa.entities.Persona"%>
<%@ page import= "alejandro.figueroa.*" %>
<%@ page import= "java.util.List" %>
<html>
	<head>
		<style>
			*{
				font-family: arial;
			}
			
			td{
				border: solid black 1px;
				padding: 10px;
			}
			
			button{
				border: none;
			    margin: 0;
			    padding: 0;
			    width: auto;
			    overflow: visible;
			
			    background: transparent;
			}
		</style>
	</head>
	
	<body>
		<h1>Personas guardadas</h1>
		
		
		<%
			List<Persona> personas = (List<Persona>) request.getAttribute("personas");
		%>
			
		<table>
		
			<%for(Persona p: personas){ %>
				<tr>
					<td><%=p.getId()%></td>	
					<td><%=p.getNombre()%></td>	
					<td><%=p.getDireccion()%></td>	
					<td><%=p.getDireccion()%></td>
					
					<td>
						<form action = "" method = "GET">
							<input type = "hidden" name= "id" value = "<%=p.getId()%>"/>
							<input type = "hidden" name= "instruccion" value = "borrar"/>
							<button type = "submit">Borrar</button>
						</form>
					</td>		
				</tr>
				
				
			<% }%>	
		</table>	
		<div>
		</div>
	</body>
</html>