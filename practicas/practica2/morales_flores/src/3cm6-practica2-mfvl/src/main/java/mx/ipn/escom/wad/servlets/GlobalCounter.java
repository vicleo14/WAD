package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalCounter extends HttpServlet {
	private int counter=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		counter++;
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("WAD:Practica 1.3");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Global counter</h1>");
		out.println("<h4>Counter:"+counter+"</h4>");
		out.println("</body>");
		out.println("</html>");
	}
}
