package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error=request.getParameter("error");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Login");
		out.println("</title>");
		out.println("</head>");
		out.println("<body  style=\"text-align: center;\">");
		out.println("<h2>Login</h2>");
		out.println("<div>");
		out.println("<form method='post' action='ServletAutenticacion' >");
		if (error!=null)
		{
			out.println("<h3 style=\"color:red;\">Username and/or password are wrong</h3>");
		}
		
		
		out.println("<input type='text' name='user' placeholder='usuario' /><br />");
		out.println("<input type='password' name='pswd' placeholder='contraseña' /><br />");
		out.println("<input type='submit' value='Send' /><br />");
		out.println("<div>");
		out.println("</form>");
		out.println("</div>");
		
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
