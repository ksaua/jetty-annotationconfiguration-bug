package no.saua.jettybug.externalJar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context was properly initialized!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
