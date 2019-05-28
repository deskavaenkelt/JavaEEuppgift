package se.theflow.vaderaktivitet.api;

//import se.theflow.vaderaktivitet.business.RequestsFromApi;

import se.theflow.vaderaktivitet.models.Place;
import se.theflow.vaderaktivitet.repository.WeatherActivityRepository;

import javax.inject.Inject;
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

    @Inject
    private WeatherActivityRepository cr;

    /*Get all the places info (for testing) AlexO*/
    @GET
    @Path("/place")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getCustomers(){
        return cr.getAllPlaces();
    }


    /*Test the API AlexO*/
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String secureApi() {
        return "Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.";
    }

    /*
    @GET
    @Path("/bad")
    //@Produces(MediaType.APPLICATION_JSON)
    public String bath() {
        String test = "hej";
        return test;
        //return RequestsFromApi.sunbathing(0);
    }
*/
}