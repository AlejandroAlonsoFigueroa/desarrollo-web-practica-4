package alejandro.figueroa.servlets;
import alejandro.figueroa.services.*;
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
	private PersonaService pService = new PersonaService();
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
		Persona p = (Persona) dao.getById(19);
		
		System.out.println(p);
		p.setDireccion("Una dirección distinta");
		Integer updated = dao.update(p);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// como retorno o redirigo a una vista con el modelo aca 
		
		
		
	
		
		String instruccion = request.getParameter("instruccion");
		
		if(request.getParameter("id") == null) {
			request.setAttribute("personas", pService.getAll());
			request.getRequestDispatcher("/lista.jsp").forward(request, response);
		}else {
			String ins = request.getParameter("instruccion");
			
			switch(ins) {
				case "borrar":
					pService.deleteById(Integer.parseInt(request.getParameter("id")));
					request.setAttribute("personas", pService.getAll());
					request.getRequestDispatcher("/lista.jsp").forward(request, response);
					break;
				case "editar":
					Persona per = pService.getById(Integer.parseInt(request.getParameter("id")));
					request.setAttribute("perEditar", per);
					request.getRequestDispatcher("/editar.jsp").forward(request, response);
					//request.setAttribute("personas", pService.getAll());
					//request.getRequestDispatcher("/lista.jsp").forward(request, response);
					break;	
			}
		}	
			
			
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String name = request.getParameter("nombre");
		String direction = request.getParameter("direccion");
		String tel = request.getParameter("telefono");
		
		Integer idCreated = dao.save(new Persona(name, direction, tel));
		
		if(idCreated != null) {
			// todo bien
		}*/
		String ins = request.getParameter("instruccion");
		
		Integer resultOfUpdateOrSave = null;
		if(ins.equals("actualizar")) {
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String dir = request.getParameter("direccion");
			String tel = request.getParameter("telefono");
			
			Integer intId = Integer.parseInt(id);
			
			Persona p = new Persona();
			
			p.setId(intId);
			p.setNombre(nombre);
			p.setTelefono(tel);
			p.setDireccion(dir);
			
			resultOfUpdateOrSave = pService.update(p);
		}else if (ins.equals("guardar")){
			
			String nombre = request.getParameter("nombre");
			String dir = request.getParameter("direccion");
			String tel = request.getParameter("telefono");
			
		
			Persona p = new Persona();
			
			p.setNombre(nombre);
			p.setTelefono(tel);
			p.setDireccion(dir);
			
			resultOfUpdateOrSave = pService.save(p);
			
		}
		//this.doGet(request, response);
		
		if(resultOfUpdateOrSave !=null) {
			request.getRequestDispatcher("/exito.jsp").forward(request, response);
		}else {
			
		}
	}

}
