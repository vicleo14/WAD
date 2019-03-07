package mx.ipn.escom.wad.tarea6.bs;

import mx.ipn.escom.wad.tarea6.dao.LoginDao;
import mx.ipn.escom.wad.tarea6.entidad.Acceso;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.UserBlockedException;
import mx.ipn.escom.wad.tarea6.exception.UserNotFoundException;

public class LoginBs {
	public static Usuario login(String username, String password) throws UserNotFoundException, UserBlockedException {
		
		Usuario usuario = LoginDao.buscarUsuarioByUsername(username);
		
		if (usuario != null) {
			if (usuario.getPassword().equals(passwordDigest(password))) {
				
				Acceso acceso = usuario.getAcceso();
				if (verificarBloqueoUsuario(acceso)) {
					throw new UserBlockedException();
				} else {
					// usuario autenticado exitosamente
				}
			} else {
				
				registrarIntentoFallido(usuario);
				System.out.println("Contrasenia erronea");
				usuario=null;
			}
		} 
		else
		{
			//System.out.println("No se encontró al usuario");
			//throw new UserNotFoundException();
		}
		return usuario;
	}

	private static void registrarIntentoFallido(Usuario usuario) {

	}
	
	private static Boolean verificarBloqueoUsuario(Acceso acceso) {
		return false;
	}
	
	private static String passwordDigest(String password) {
		return password;
	}
}
