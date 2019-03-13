package mx.ipn.escom.wad.filters;
import java.util.logging.Logger;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;

public class Filter1 implements Filter {

    public Filter1() {
       
    }

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String recursoPrivado="/3cm6-practica2-mfvl/privado";
		boolean permitido=false;
		HttpServletRequest req=(HttpServletRequest)request;
		Date fecha =new Date();
		DateFormat df=new SimpleDateFormat("dd/MM/yy | HH:mm:ss");
		String url=req.getRequestURL().toString();
		//System.out.println("LOG: "+req.getRemoteAddr()+" | "+df.format(fecha)+" | "+req.getMethod()+" |"+req.getRequestURL());
		//chain.doFilter(request, response);
		if(url.indexOf(recursoPrivado)!=-1)//Retorna -1 si no lo contiene
		{
			permitido=false;
			//System.out.println("Privado");
			
		}
		else
		{
			permitido=true;
			//System.out.println("Público");
		}
		
		
		HttpSession session=req.getSession();
		Object o=session.getAttribute(NombreObjetosSession.USER);
		if((o!= null && o instanceof Usuario) || permitido)
		{
			System.out.println("LOG: "+req.getRemoteAddr()+" | "+df.format(fecha)+" | "+req.getMethod()+" |"+req.getRequestURL());
			chain.doFilter(request, response);
		}
		else
		{
			System.out.println("LOG: "+req.getRemoteAddr()+" | "+df.format(fecha)+" | "+req.getMethod()+" |"+req.getRequestURL()+"| NOT ALLOWED");
			HttpServletResponse resp=(HttpServletResponse)response;
			//System.out.println("Valor de recurso:"+permitido);
			if(permitido)
				chain.doFilter(request, response);
			else
				resp.sendError(666);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
