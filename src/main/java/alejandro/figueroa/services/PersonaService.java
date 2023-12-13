package alejandro.figueroa.services;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import alejandro.figueroa.dao.*;
import alejandro.figueroa.entities.*;
public class PersonaService {
	
	Logger LOG = Logger.getLogger(PersonaService.class.getName());
	
	private PersonaDAO personaDAO = new PersonaDAO();
	
	/*
	 * Guarda una persona en la tabla PERSONAS
	 */
	public Integer save(Persona p) {
		return this.personaDAO.save(p);
	}
	
	/*
	 * Actualiza una persona en la tabla PERSONAS
	 */
	public Integer update(Persona p) {
		return this.personaDAO.update(p);
	}
	/*
	 * Obtiene todos los registros de la tabla PERSONAS
	 */
	public List<GenericEntity> getAll() {
		return this.personaDAO.getAll();
	}
	/*
	 * Obtiene un registro de la tabla PERSONAS por id
	 */
	public Persona getById(Integer id) {
		if(id == null) {
			LOG.log(Level.SEVERE, "El id no debería ser nulo, no se consulta");
			return null;
		}
		Persona p = (Persona) this.personaDAO.getById(id);
		
		return p;
	}
	
	/*
	 * Borra una persona de PERSONAS por id
	 */
	public Integer deleteById(Integer id) {
		if(id == null) {
			LOG.log(Level.SEVERE, "El id no debería ser nulo, no se borra nada");
			return null;
		}
		return this.personaDAO.deleteById(id);
	}
	
	/*
	 * Elimina todos los registros de la tabla PERSONAS
	 */
	public Integer deleteAll() {
		return this.personaDAO.deleteAll();
	}

}
