package gr.insurit.ping.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author insurit.gr
 */
@Path("ping")
public class PingResource {

    @GET
    public String ping() {
        return "Hello Java EE 8!";
    }

}
