package mx.ipn.escom.wad.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo7
 */
public class Ejemplo7 extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		Double valor=Math.random();
		System.out.println("Valor generado");
		System.out.println("Paso por 7 "+valor);
		request.setAttribute("atributoEjemplo", valor);
		RequestDispatcher rd=request.getRequestDispatcher("Ejemplo7A");
		rd.forward(request, response);
		
		/*
		 * Request dispatcher administra las peticiones
		 * */
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
