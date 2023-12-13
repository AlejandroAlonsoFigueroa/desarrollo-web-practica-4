package alejandro.figueroa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Persona extends GenericEntity{

	private String nombre;
	private String direccion;
	private String telefono;
	
}
