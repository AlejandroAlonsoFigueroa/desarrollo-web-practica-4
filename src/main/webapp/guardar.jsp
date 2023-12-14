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
	<h1>Guardar personas</h1>
	<body>
		<form action = "personas" method  = "POST">
			<input type = "hidden" name = "instruccion" value = "guardar"/>
			<div>
				<div>
					<p>Nombre</p>	
				</div>
				<input type = "text" name = "nombre"/>
			</div>
			<div>
				<div>
					<p>Dirección</p>	
				</div>
				<input type = "text" name = "direccion"/>
			</div>
			<div>
				<div>
					<p>Teléfono</p>	
				</div>
				<input type = "text" name = "telefono" />
			</div>
			<button type = "submit">Guardar cambios</button>
		</form>
	</body>
</html>