package wp;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ls
 *
 */
public class ls implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener {

	 @Override
	  public void requestDestroyed(ServletRequestEvent sre) {
	    ServletContext servletContext = sre.getServletContext();
	    servletContext.log("Request destroyed");
	    System.out.println("System.out: Request destroyed");
	    System.out.println("Time : " + new Date());
	  }
	  @Override
	  public void requestInitialized(ServletRequestEvent sre) {
	    ServletContext servletContext = sre.getServletContext();
	    servletContext.log("New request initialized");
	    System.out.println("System.out: New request initialized");
	    System.out.println("Time : " + new Date());
	  }

}
