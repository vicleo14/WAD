package mx.ipn.escom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private Connection con=null;
	
	public Conexion()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/homework-6";
			con=DriverManager.getConnection(url,"postgres","postgres");
			/*if(con!=null)
				System.out.println("Conexion exitosa");
			else
				System.out.println("Conexion fallida");*/
		}
		catch(Exception ex)
		{
			System.out.println("Error al conectar");
		}
		
	}
	public ResultSet execute(String query)
	{
		ResultSet res=null;
		try {
			Statement st=con.createStatement();
			res=st.executeQuery(query);
		}
		catch(Exception ex)
		{
			
		}
		return res;
	}
	public void close()
	{
		try
		{
			con.close();
		}
		catch(SQLException ex)
		{
			System.out.println("Error al cerrar la conexión");
		}
	}

}
