package se.theflow.vaderaktivitet.api;

//import se.theflow.vaderaktivitet.business.RequestsFromApi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/weatherActivityApi")
@Path("/v1.0")
public class weatherActivityApi extends Application {

    //@Inject
    //private Repository cr;

    @GET
    @Path("/bad")
    //@Produces(MediaType.APPLICATION_JSON)
    public String bath() {
        String test = "hej";
        return test;
        //return RequestsFromApi.sunbathing(0);
    }
}