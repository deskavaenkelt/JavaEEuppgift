package se.theflow.vaderaktivitet.api;

//import se.theflow.vaderaktivitet.business.CompromiseMagic;
import se.theflow.vaderaktivitet.business.UpdateCacheParametersInDatabase;
import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;
import se.theflow.vaderaktivitet.models.Place;
import se.theflow.vaderaktivitet.models.Users;
import se.theflow.vaderaktivitet.repository.UserRepository;
import se.theflow.vaderaktivitet.repository.WeatherActivityRepository;
import se.theflow.vaderaktivitet.repository.WeatherToCacheTablesRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/weatherActivityApi")
@Path("/v1.0")
@Consumes(MediaType.APPLICATION_JSON)   // under test
public class weatherActivityApi extends Application {

    // Inject repositorys
    @Inject
    private WeatherActivityRepository cr;

    @Inject
    private UserRepository userRepository;

    @Inject
    private WeatherToCacheTablesRepository weatherToCacheTablesRepository;

    @Inject
    private UpdateCacheParametersInDatabase updateCacheParametersInDatabase;

    /*@Inject
    private CompromiseMagic compromiseMagic;*/

    /*Get all the places info (for testing) AlexO*/
    @GET
    @Path("/place")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getAllPlaces(){
        return cr.getAllPlaces();
    }

    /*Test the API AlexO*/
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String testApi() {
        return "Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.";
    }

    @GET
    @Path("/secured")
    @Produces(MediaType.TEXT_PLAIN)
    public String secureApi() {
        return "ACCESS GRANTED: you are verified";
    }

    @GET
    @Path("/open")
    @Produces(MediaType.TEXT_PLAIN)
    public String openApi() {
        return "OPEN CONNECTION: does not require login.";
    }


    // Users
    @GET
    @Path("listusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUsers() {
        return userRepository.getAllUsers();
    }



    @GET
    @Path("users/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    // id 1-4,
    // Return one user object
    public String getId(@PathParam("id") int id) {
        //return userRepository.findUserByUserName(id);
        return userRepository.findUserByUserName(id).getUserName();
    }


/*
    @POST
    @Path("secured/createuser")
    public Response createNewUserAccount(Users users) {
        userRepository.createNewUser(users);

        return Response.ok().build();
    }
*/
    // CachePlaceParametersModel
    @GET
    @Path("/cacheplaceparameters")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CachePlaceParametersModel> getAllPlaceParemeters() {
        return weatherToCacheTablesRepository.getAllPlaces();
    }

    // CachePlaceParametersModel
    @GET
    @Path("/cacheplaceparameters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CachePlaceParametersModel> getAllPlaceParemeters(@PathParam("id") int id) {
        return weatherToCacheTablesRepository.findPlaceByPlaceId(id);
    }

    // Update parameters
    @GET
    @Path("secured/updategoteborg")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateGoteborg() {
        System.out.println("dummy Goteborg");
        updateCacheParametersInDatabase.dummyGoteborg();

        return "Update completed";
    }

    @GET
    @Path("secured/magic")
    @Produces(MediaType.TEXT_PLAIN)
    public String runMagic() {
        System.out.println("Magic is running");
//        compromiseMagic.updateAllPoints();
        return "Happy magic!";
    }


    /*Get points for diffrent places AlexO*/
    @GET
    @Path("/fishing")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getFishing(){
        return cr.getFishingPoints();
    }
    @GET
    @Path("/outdoorseating")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getOutdoorSeating(){
        return cr.getOutdoorSeatingPoints();
    }
    @GET
    @Path("/sunbathing")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getSunBathing(){
        return cr.getSunBathingPoints();
    }
    @GET
    @Path("/volleyball")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getVolleyball(){
        return cr.getVolleyBallPoints();
    }
    @GET
    @Path("/windsurfing")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getWindsurfing(){
        return cr.getWindSurfingPoints();
    }
}