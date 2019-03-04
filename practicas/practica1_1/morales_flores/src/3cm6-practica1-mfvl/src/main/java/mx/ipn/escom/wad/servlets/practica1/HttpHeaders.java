package mx.ipn.escom.wad.servlets.practica1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class HttpHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HttpHeaders() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Enumeration<String> nombre_headers=request.getHeaderNames();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("WAD:Practica 1.1");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>HTTP Headers</h1>");
		out.println("<ul>");
		while(nombre_headers.hasMoreElements())
		{
			String nombreH=nombre_headers.nextElement();
			String value=request.getHeader(nombreH);
			out.println("<li>"+nombreH+": "+value+"</li>");			
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
	}

	

}
