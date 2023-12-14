<%@page import="alejandro.figueroa.entities.Persona"%>
<html>
	<head>
		<style>
			p{
				margin: 0;
				padding: 0;
			}
			*{
				font-family: arial;
			}
			
			button{
				border: solid black 1px;
			    margin: 0;
			    padding: 10px 15px;
			    width: auto;
			    overflow: visible;
			
			    background: transparent;
			    color: white;
			    background-color: blue;
			}
		</style>
	</head>
	<% Persona p = (Persona) request.getAttribute("perEditar");%>
	<body>
		<form action = "personas" method  = "POST">
			<input type = "hidden" name = "instruccion" value = "actualizar"/>
			<div>
				<div>
					<p>Id</p>	
				</div>
				<input type = "text" name = "id" value = "<%=p.getId()%>"/>
			</div>
			<div>
				<div>
					<p>Nombre</p>	
				</div>
				<input type = "text" name = "nombre" value = "<%=p.getNombre()%>"/>
			</div>
			<div>
				<div>
					<p>Dirección</p>	
				</div>
				<input type = "text" name = "direccion" value = "<%=p.getDireccion()%>"/>
			</div>
			<div>
				<div>
					<p>Teléfono</p>	
				</div>
				<input type = "text" name = "telefono" value = "<%=p.getTelefono()%>"/>
			</div>
			<button type = "submit">Guardar cambios</button>
		</form>
	</body>
</html>