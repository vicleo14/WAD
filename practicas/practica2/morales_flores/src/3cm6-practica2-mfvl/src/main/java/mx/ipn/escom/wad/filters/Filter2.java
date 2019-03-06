package mx.ipn.escom.wad.filters;

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

public class Filter2 implements Filter {

    public Filter2() {
    }
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req=(HttpServletRequest)request;
		Date fecha =new Date();
		DateFormat df=new SimpleDateFormat("dd/MM/yy | HH:mm:ss");
		
		System.out.println("Filter2: "+req.getRemoteAddr()+" | "+df.format(fecha)+" | "+req.getMethod()+" |"+req.getRequestURL()+"| NOT ALLOWED");
		HttpServletResponse resp=(HttpServletResponse)response;
		resp.sendError(666);
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
