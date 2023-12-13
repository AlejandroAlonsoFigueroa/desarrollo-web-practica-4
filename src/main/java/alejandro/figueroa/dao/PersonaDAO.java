package alejandro.figueroa.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import alejandro.figueroa.entities.GenericEntity;
import alejandro.figueroa.entities.Persona;

public class PersonaDAO implements IGenericDAO{
	Logger LOG = Logger.getLogger(PersonaDAO.class.getName());
	
	private String sqlSave 
	= "INSERT INTO PERSONAS(NOMBRE, DIRECCION, TELEFONO) VALUES(?, ?, ?)";
	
	private String sqlUpdate = "UPDATE PERSONAS SET NOMBRE = ?, DIRECCION = ?, TELEFONO = ? WHERE"
			+ " ID = ?";
	
	private String sqlDeleteById = "DELETE FROM PERSONAS WHERE ID = ?";
	private String sqlDeleteAll = "DELETE FROM PERSONAS";
	private String sqlGetAll = "SELECT * FROM PERSONAS";
	
	
	Conexion c = new Conexion();

	@Override
	public Integer save(GenericEntity e) {
		LOG.log(Level.INFO, "Incia el metodo save, para guardar a una persona");
		Integer lastIdInserted = null;
		Persona p = (Persona) e;
		Connection conn = null;
		try {
			conn = c.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sqlSave, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getDireccion());
			ps.setString(3, p.getTelefono());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				lastIdInserted = rs.getInt(1);
				LOG.log(Level.INFO, "Inserted with id: "+lastIdInserted);
            }
			
		}catch(SQLException ex) {
			LOG.log(Level.SEVERE, "Ocurrió un error al intentar guardar una persona");
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				LOG.log(Level.SEVERE, "No se pudo cerrar la conexión");
			}
		}
		return lastIdInserted;
	}

	@Override
	public void update(GenericEntity e) {
		
	}

	@Override
	public Integer deleteById(Integer id) {
		LOG.log(Level.INFO, "Incia el metodo delete, para eliminar a una persona");
		Integer rowsModified = null;
		Connection conn = null;
		
		if(id == null) {
			LOG.log(Level.SEVERE, "El id no debería ser nulo, no se borra nada");
			return null;
		}
		
		try {
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlDeleteById, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, id);
			
			rowsModified = ps.executeUpdate();
			
			LOG.log(Level.INFO, "Registros eliminados: "+rowsModified);
		}catch(SQLException ex) {
			LOG.log(Level.SEVERE, "Ocurrió un error al intentar guardar una persona");
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				LOG.log(Level.SEVERE, "No se pudo cerrar la conexión");
			}
		}
		return rowsModified;
	}

	@Override
	public Object getById(Integer id) {
		return null;
	}

	@Override
	public Integer deleteAll() {
		LOG.log(Level.INFO, "Incia el metodo deleteAll, para eliminar a todas las personas");
		Integer rowsModified = null;
		Connection conn = null;
		try {
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlDeleteAll, Statement.RETURN_GENERATED_KEYS);
					
			rowsModified = ps.executeUpdate();
			
			LOG.log(Level.INFO, "Registros eliminados: "+rowsModified);
		}catch(SQLException ex) {
			LOG.log(Level.SEVERE, "Ocurrió un error al intentar guardar una persona");
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				LOG.log(Level.SEVERE, "No se pudo cerrar la conexión");
			}
		}
		return rowsModified;
	}

	@Override
	public List<GenericEntity> getAll() {
		List<GenericEntity> personas = new ArrayList();
		LOG.log(Level.INFO, "Incia el metodo getAll, para obtener a todas las personas");
		Connection conn = null;
		Persona pTemp;
		try {
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlGetAll, Statement.RETURN_GENERATED_KEYS);
					
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next()) {
				pTemp = new Persona(rs.getString("NOMBRE"), rs.getString("DIRECCION"), rs.getString("TELEFONO"));
				personas.add(pTemp);
			}
		}catch(SQLException ex) {
			LOG.log(Level.SEVERE, "Ocurrió un error al intentar guardar una persona");
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				LOG.log(Level.SEVERE, "No se pudo cerrar la conexión");
			}
		}
		
		return personas;
	}
	

}
