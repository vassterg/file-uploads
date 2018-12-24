package gr.insurit;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author insurit.gr
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
        @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources and features
        classes.add(MultiPartFeature.class);
     //   classes.add(MultiPartResource.class);
     //   classes.add(LoggingFilter.class);
        return classes;
    }
}
