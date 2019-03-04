package mx.ipn.escom.web.servlets;
import mx.ipn.escom.database.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String usrId=(String)request.getAttribute("id");
		String name="",rol="";
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
		if(usrId!=null)
		{
			String query="SELECT tx_first_name,tx_last_name_a,tx_last_name_b FROM person "+
					" WHERE id_person="+usrId+";";
			String query2="SELECT role.nb_role "+
					"FROM role INNER JOIN ACCOUNT ON role.id_role=account.id_role "+
					"WHERE account.id_user="+usrId+";";
			Conexion con=new Conexion();
			ResultSet resultado=con.execute(query);
			ResultSet resultado2=con.execute(query2);
			try
			{
				resultado.next();
				name=resultado.getString(1)+" "+resultado.getString(2)+" "+resultado.getString(3);
				resultado2.next();
				rol=resultado2.getString(1);
			}
			catch(SQLException sqlex)
			{
				System.out.println(sqlex.toString());
			}
			con.close();
			out.println("<h3>"+name+"</h3>");
			out.println("<h4>"+rol+"</h4>");
		}
		else
			response.sendError(666);
		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
