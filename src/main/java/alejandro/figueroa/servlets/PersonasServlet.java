package alejandro.figueroa.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alejandro.figueroa.dao.*;
import alejandro.figueroa.entities.GenericEntity;
import alejandro.figueroa.entities.Persona;
/**
 * Servlet implementation class PersonasServlet
 */
@WebServlet("/PersonasServlet")
public class PersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PersonaDAO dao = new PersonaDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//dao.save(new Persona("Ale", "Su casa", "32432"));
		List<GenericEntity> personas = dao.getAll();
		
		/*for(GenericEntity p: personas) {
			Persona p2 = (Persona) p;
			System.out.println(p2.getDireccion());
			
		}*/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nombre");
		String direction = request.getParameter("direccion");
		String tel = request.getParameter("telefono");
		
		Integer idCreated = dao.save(new Persona(name, direction, tel));
		
		if(idCreated != null) {
			// todo bien
		}
			
	}

}
