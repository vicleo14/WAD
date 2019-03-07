package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.escom.database.Conexion;
import java.sql.ResultSet;

public class ServletAutenticacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(666);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pswd=request.getParameter("pswd");
		
		try 
		{
			String query="SELECT id_user FROM users"+
			" WHERE tx_login='"+user+"' AND tx_password='"+pswd+"';";
			Conexion con=new Conexion();
			ResultSet resultado=con.execute(query);
			if(resultado.next())
			{	
				String userId=resultado.getString(1);
				request.setAttribute("id",userId );				
				request.getRequestDispatcher("Home").forward(request, response);
			}
			else
			{
				response.sendRedirect("FormLogIn?error=true");
			}
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error:"+ex.toString());
		}
		
	}
	

}
