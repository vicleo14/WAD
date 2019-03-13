package mx.ipn.escom.wad.tarea6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.tarea6.bs.LoginBs;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;
import mx.ipn.escom.wad.tarea6.exception.UserBlockedException;
import mx.ipn.escom.wad.tarea6.exception.UserNotFoundException;

/**
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario;
		try {
			//Logica de negocios para tratar la respuesta de 
			String user=request.getParameter("username");
			String pswd=request.getParameter("password");
			//System.out.println("User: "+user+", pass:"+pswd);
			usuario = LoginBs.login(user, pswd);
			HttpSession session = request.getSession();
			session.setAttribute(NombreObjetosSession.USER, usuario);
			
			if(usuario!=null)
			{
				System.out.println("Usuario"+usuario.getLogin()+" subido a la sesión");
				RequestDispatcher rd = request.getRequestDispatcher("../privado/Home");
				rd.forward(request, response);
			}
			else
			{
				//response.sendError(666);
				response.sendRedirect("../?error=true");
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
