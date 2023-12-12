package alejandro.figueroa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Persona extends GenericEntity{

	private String nombre;
	private String direccion;
	private String telefono;
	
}
