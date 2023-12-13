package alejandro.figueroa.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {

	Logger logger = Logger.getLogger(Conexion.class.getName());
	private String url = "jdbc:postgresql://localhost:5432/practica4";
    private String pws = "ajxy2381";
    private String user = "postgres";
    
	private Connection c;
    private static Conexion s;
    
    public static Conexion getInstance() {
        if(s==null){
            s=new Conexion();
        }
        return s;
    }
   
    public Conexion(){
    }
    
    public Connection getConnection(){
    	 try {
         	Class.forName("org.postgresql.Driver");
         }catch(ClassNotFoundException e) {
         	logger.info("No fué posible cargar el controlador de la BBDD");
         }
         
         try {
             c = DriverManager.getConnection(url, user, pws);
         } catch (SQLException ex) {
             logger.info("No es posible conectarse a la base de datos");
         }
         return c;
    
    }
}
