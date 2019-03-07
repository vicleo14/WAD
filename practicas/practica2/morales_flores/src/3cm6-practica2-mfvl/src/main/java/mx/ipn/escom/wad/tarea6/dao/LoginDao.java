package mx.ipn.escom.wad.tarea6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import mx.ipn.escom.wad.tarea6.entidad.Cuenta;
import mx.ipn.escom.wad.tarea6.entidad.Persona;
import mx.ipn.escom.wad.tarea6.entidad.Rol;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;

public class LoginDao {
	public static Usuario buscarUsuarioByUsername(String username) {
		Usuario usuario;
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/homework-6", "postgres", "postgres");
			if (connection != null) {
				System.out.println("---> La conexión se realizó exitosamente");
				usuario=null;
				//usuario.setPassword("123");
				//PreparedStatement preparedStatement = connection.prepareStatement("");
				//ResultSet resulset = preparedStatement.executeQuery();
				// Ingresar código para búsqueda del usuario con base en el username
				try 
				{
					String query="SELECT id_user,tx_login,tx_password FROM users"+
					" WHERE tx_login='"+username+"';";
					Statement st=connection.createStatement();
					ResultSet resultado=st.executeQuery(query);
					if(resultado.next())
					{	
						int userId=Integer.parseInt(resultado.getString(1));
						String userLogin=resultado.getString(2);
						String userPassword=resultado.getString(3);
						String query2="SELECT tx_first_name,tx_last_name_a,tx_last_name_b FROM person "+
								" WHERE id_person="+userId+";";
						//String query3="SELECT *_role "+
						//		"FROM role INNER JOIN ACCOUNT ON role.id_role=account.id_role "+
						//		"WHERE account.id_user="+userId+";";
						String query3="SELECT * "+
								"FROM account "+
								"WHERE id_user="+userId+";";
						usuario = new Usuario();
						Persona person=new Persona();
						Cuenta cuenta=new Cuenta();
						Rol rol=new Rol();
						
						Statement st2=connection.createStatement();
						
						ResultSet resultado2=st2.executeQuery(query2);
						Statement st3=connection.createStatement();
						ResultSet resultado3=st3.executeQuery(query3);
						try
						{
							resultado2.next();
							person.setNombre(resultado2.getString(1));
							person.setPrimerApellido(resultado2.getString(2));
							person.setSegundoApellido(resultado2.getString(3));
							
							
							resultado3.next();
							cuenta.setId(Integer.parseInt(resultado3.getString(1)));
							cuenta.setIdRol(Integer.parseInt(resultado3.getString(2)));
							cuenta.setIdUsuario(Integer.parseInt(resultado3.getString(3)));
							
							//System.out.println(resultado3.getString(1)+","+resultado3.getString(2)+","+resultado3.getString(3)+","+resultado3.getString(4)+","+resultado3.getString(5));
							String query4="SELECT * "+
									"FROM role "+
									"WHERE id_role="+cuenta.getIdRol()+";";
							
							resultado3=st3.executeQuery(query4);
							resultado3.next();
							rol.setId(Integer.parseInt(resultado3.getString(1)));
							rol.setNombre(resultado3.getString(2));
							rol.setDescripcion(resultado3.getString(3));
							//System.out.println("rol_id:"+rol.getId());
							//System.out.println("rol_id:"+rol.getNombre());
							//System.out.println("rol_id:"+rol.getDescripcion());
							
							
							//cuenta.setInicio(new Date(resultado3.getString(4)));
							//cuenta.setFin(new Date(resultado3.getString(5)));
							
							
						}
						catch(SQLException sqlex)
						{
							System.out.println(sqlex.toString());
						}
						ArrayList<Cuenta> cuentas=new ArrayList<Cuenta>();
						cuenta.setRol(rol);
						cuentas.add(cuenta);
						
						usuario.setLogin(userLogin);
						usuario.setPassword(userPassword);
						usuario.setId(userId);
						usuario.setPersona(person);
						usuario.setCuentas(cuentas);
						
						
						
					}
					else
					{
						System.out.println("No se encontraron coincidencias con usuario.");
					}
				}
				catch(Exception ex)
				{
					System.out.println("Error:"+ex.toString());
				}
			} else {
				// Error al conectarse a la base de datos
				usuario = null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			usuario = null;
		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
		} finally {

		}
		return usuario;
	}
}
