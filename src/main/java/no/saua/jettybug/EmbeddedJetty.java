package no.saua.jettybug;

import java.net.URL;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;

public class EmbeddedJetty {
    public static final void main(String args[]) throws Exception {
        // Create the server
        Server server = new Server(8080);

        String webappPath = "src/main/webapp";
        // For eclipse
        URL warLocation = EmbeddedJetty.class.getProtectionDomain().getCodeSource().getLocation();
        if (warLocation.toString().endsWith(".war")) {
            webappPath = warLocation.getPath();
        }

        // Create a WebApp
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(webappPath);

        // This works:
        webapp.setConfigurations(new Configuration[] { new AnnotationConfiguration(), new WebInfConfiguration(),
                 new FragmentConfiguration() });

        // This does not work:
        //webapp.setConfigurations(new Configuration[] { new AnnotationConfiguration(), new WebInfConfiguration() });

        server.setHandler(webapp);

        server.start();
        server.join();
    }
}
