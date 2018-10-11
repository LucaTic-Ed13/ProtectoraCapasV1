package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Animal;
import services.AnimalService;
import services.IAnimalService;

/**
 * Servlet implementation class AnimalPresenter
 */
@WebServlet(
        name = "MainPageServlet",
        urlPatterns = {"/MainPageServlet"},
        asyncSupported = false
)
public class AnimalPresenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalPresenter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private IAnimalService animalService = new AnimalService();

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//PASO 01: Recoger informacion
        int id = Integer.parseInt(request.getParameter("Animal"));
        
        //PASO 02: Recopilar la respuesta
        Animal result =  animalService.getAnimal(id);
        request.setAttribute("Animal", result);
        
        //PASO 03: Salir      
        RequestDispatcher view = request.getRequestDispatcher("profile_cat.jsp");
        view.forward(request, response);
        //request.getRequestDispatcher("result.jsp").forward(request, response);
        
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}