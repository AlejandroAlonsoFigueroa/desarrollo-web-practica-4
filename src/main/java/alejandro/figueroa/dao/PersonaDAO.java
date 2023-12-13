package alejandro.figueroa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import alejandro.figueroa.entities.GenericEntity;
import alejandro.figueroa.entities.Persona;

public class PersonaDAO implements IGenericDAO{
	private String sqlSave 
	= "INSERT INTO PERSONAS(NOMBRE, DIRECCION, TELEFONO) VALUES(?, ?, ?)";
	
	private String sqlUpdate = "UPDATE PERSONAS SET NOMBRE = ?, DIRECCION = ?, TELEFONO = ? WHERE"
			+ " ID = ?";
	
	private String sqlDeleteById = "DELETE FROM PERSONAS WHERE ID = ?";
	private String sqlDeleteAll = "DELETE FROM PERSONAS";
	private String sqlGetAll = "SELECT * FROM PERSONAS";
	
	// Ver que pedo con la conexión, no me convence mucho
	Conexion c = new Conexion();

	@Override
	public Integer save(GenericEntity e) {
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
				System.out.println("Inserted with id: "+lastIdInserted);
            }
			
		}catch(SQLException ex) {
			System.out.println("Error alv");
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				System.out.println("No se pudo cerrar la conexión");
			}
		}
		// Si lastIdInserted sigue en nulo, algo salió mal
		return lastIdInserted;
	}

	@Override
	public void update(GenericEntity e) {
		
	}

	@Override
	public void deleteById(Integer id) {
	}

	@Override
	public Object getById(Integer id) {
		return null;
	}

	@Override
	public Integer deleteAll() {
		return null;
	}

	@Override
	public void getAll() {
	}
	

}
