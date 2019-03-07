package mx.ipn.escom.wad.listeners;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener1
 *
 */
public class Listener1 implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestAttributeListener, ServletRequestListener {

	 private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	 private Date date = new Date();
    /**
     * Default constructor. 
     */
    public Listener1() {
        System.out.println("--->Listener1 funcionando");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	Date date = new Date();
    	HttpSession s=se.getSession();
    	System.out.println("Listener1("+dateFormat.format(date)+")::Se ha creado una sesión:"+s.getCreationTime()+" con el ID:"+s.getId());
    }

    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	Date date = new Date(); 
    	String name=event.getName();
         String value=event.getValue().toString();
         System.out.println("Listener1("+dateFormat.format(date)+")::Se ha eliminado el atributo:"+name+" con el valor:"+value + " del ServletContext");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	Date date = new Date();
    	String name=srae.getName();
        String value=srae.getValue().toString();
        
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha añadido el atributo:"+name+" con el valor:"+value + " del ServletRequest");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	Date date = new Date();
    	String name=event.getName();
        String value=event.getValue().toString();
        
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha remplazado el atributo:"+name+" con el valor:"+value + " en la sesion");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	Date date = new Date();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha iniciado el ServletContext");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
    	Date date = new Date();
    	String name=event.getName();
        String value=event.getValue().toString();
        
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha añadido el atributo:"+name+" con el valor:"+value + "del ServletContext");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	Date date = new Date();
    	String sername=sre.getServletRequest().getServerName();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha destruido el objeto request de :"+sername);
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	Date date = new Date();
    	String name=srae.getName();
        String value=srae.getValue().toString();
        
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha removido el atributo:"+name+" con el valor:"+value + "del ServletRequest");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	Date date = new Date();
    	String name=sre.getSource().toString();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha inicializado el ServletRequest por:"+name);
   
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	Date date = new Date();
    	String name=se.getSession().getId();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha destruido la sesión:"+name);
   
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	Date date = new Date();
    	String name=sce.toString();
        
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha destruido el ServletContext");
   
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	Date date = new Date();
    	String name=srae.getName();
    	String value=srae.getValue().toString();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha remplazado el atributo:"+name+" por: "+value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	Date date = new Date();
    	String name=event.getName();
    	String value=event.getValue().toString();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha añadido el atributo:"+name+" con valor "+value+" en la sesión");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	Date date = new Date();
    	String name=event.getName();
    	String value=event.getValue().toString();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha removido el atributo:"+name+" con valor "+value+" en la sesión");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	Date date = new Date();
    	String name=event.getName();
    	String value=event.getValue().toString();
        System.out.println("Listener1("+dateFormat.format(date)+")::Se ha remplazado el atributo:"+name+" con valor "+value+" en el ServletContext");
    }
	
}
