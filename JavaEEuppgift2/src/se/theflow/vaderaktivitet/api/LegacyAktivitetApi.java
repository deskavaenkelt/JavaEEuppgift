package se.theflow.vaderaktivitet.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/aktivitetapi")
@Path("/v1.0")
public class LegacyAktivitetApi extends Application {

    /*@GET
    @Path("/aktivitet")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity>*/
}
