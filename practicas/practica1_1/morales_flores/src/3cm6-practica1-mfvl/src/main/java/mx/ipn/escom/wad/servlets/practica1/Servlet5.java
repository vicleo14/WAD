package mx.ipn.escom.wad.servlets.practica1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.escom.database.Conexion;

public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet5() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("WAD:Practica 1.5");
		out.println("</title>");
		out.println("</head>");
		out.println("<body style=\"text-align: center;\">");
		out.println("<h1>Users</h1>");
		out.println("<div>");
		out.println("<table border='1' cellpadding='0' cellspacing='0'>");
		out.println("<tr>");
		out.println("<th>First Name(job title)</th>");
		out.println("<th>Last Name</th>");
		out.println("<th>Second Last Name</th>");
		out.println("<th>CURP</th>");
		out.println("<th>Birth day</th>");
		out.println("<th>Nickname</th>");
		out.println("</tr>");
		
		String query="SELECT tx_first_name, tx_last_name_a,tx_last_name_b,tx_curp,fh_birth,tx_login "+
					"FROM person INNER JOIN users "+
					"ON person.id_person=users.id_user;" ;
		ResultSet resultado=null;
		try
		{
			Conexion con=new Conexion();
			resultado=con.execute(query);
			con.close();
			while(resultado.next())
			{
				out.println("<tr>");
				out.println("<td>"+resultado.getString(1)+"</td>");
				out.println("<td>"+resultado.getString(2)+"</td>");
				out.println("<td>"+resultado.getString(3)+"</td>");
				out.println("<td>"+resultado.getString(4)+"</td>");
				out.println("<td>"+resultado.getString(5)+"</td>");
				out.println("<td>"+resultado.getString(6)+"</td>");
				out.println("</tr>");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error en la lectura a la BD:"+ex.toString());
		}
		
		out.println("</table>");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<button onclick=\"location.href='form5.html';\" value='New'>New</button>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname=request.getParameter("name");
		String lname=request.getParameter("lname");
		String slname=request.getParameter("sname");
		String curp=request.getParameter("curp");
		String bd=request.getParameter("birthday");
		String login=request.getParameter("login");
		String pswd=request.getParameter("pswd");
		String query1="INSERT INTO PERSON (tx_first_name,tx_last_name_a,"+
		"tx_last_name_b,tx_curp,fh_birth) VALUES"+
		"('"+fname+"','"+lname+"'," + 
		"'"+slname+"','"+curp+"','"+bd+"')";
		String query2="SELECT id_person FROM PERSON WHERE tx_curp LIKE '"+curp+"'";
		try {
			Conexion con=new Conexion();
			con.insert(query1);
			ResultSet r1=con.execute(query2);
			r1.next();
			String id=r1.getString(1);
			String query3="INSERT INTO USERS VALUES("+id+",'"+login+"','"+pswd+"')";
			con.insert(query3);
			con.close();
		}
		catch(Exception ex) 
		{
			System.out.println("Error al insertar nuevo usuario:"+ex.toString());
		}
		
		response.sendRedirect("Servlet5");
		
	}

}
