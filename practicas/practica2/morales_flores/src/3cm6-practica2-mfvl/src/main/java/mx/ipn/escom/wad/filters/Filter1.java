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

public class Filter1 implements Filter {

    public Filter1() {
       
    }

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		Date fecha =new Date();
		DateFormat df=new SimpleDateFormat("dd/MM/yy | HH:mm:ss");
		
		System.out.println("Filter: "+req.getRemoteAddr()+" | "+df.format(fecha)+" | "+req.getMethod()+" |"+req.getRequestURL());
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
