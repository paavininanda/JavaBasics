package jersey;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("jersey")
public class ApplicationConfig 
  extends Application {
  
//    @Override
//    public void onStartup(ServletContext servletContext) 
//      throws ServletException {
//  
//        AnnotationConfigWebApplicationContext context 
//          = new AnnotationConfigWebApplicationContext();
//  
//        servletContext.addListener(new ContextLoaderListener(context));
//        servletContext.setInitParameter(
//          "contextConfigLocation", "com.baeldung.server");
//    }
}