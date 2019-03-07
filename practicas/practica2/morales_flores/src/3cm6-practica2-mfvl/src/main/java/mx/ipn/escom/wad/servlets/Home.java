package mx.ipn.escom.wad.servlets;
import mx.ipn.escom.wad.tarea6.exception.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.wad.tarea6.entidad.*;

public class Home extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Home");
		out.println("</title>");
		out.println("</head>");
		out.println("<body  style=\"text-align: center;\">");
		out.println("<h2>Welcome</h2>");
		out.println("<div>");
		HttpSession session =request.getSession();
		Object o=session.getAttribute(NombreObjetosSession.USER);
		if(o instanceof Usuario)
		{
			Usuario us=(Usuario)o;
			int usrId=us.getId();
			String name=us.getPersona().getNombre()+" "+us.getPersona().getPrimerApellido()+" "+us.getPersona().getSegundoApellido();
			String rol;
			out.println("<h3>"+name+"</h3>");
			out.println("<h4>"+us.getCuentas().get(0).getRol().getNombre()+"</h4>");
		}
		else
		{
			response.sendError(666);
		}
		
		
			
		
		
		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
