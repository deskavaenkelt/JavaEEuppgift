package se.theflow.vaderaktivitet.api;

//import se.theflow.vaderaktivitet.business.RequestsFromApi;

import se.theflow.vaderaktivitet.business.UpdateCacheParametersInDatabase;
import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;
import se.theflow.vaderaktivitet.models.Place;
import se.theflow.vaderaktivitet.models.Users;
import se.theflow.vaderaktivitet.repository.UpdateCachePlaceParametersRepository;
import se.theflow.vaderaktivitet.repository.UserLogin;
import se.theflow.vaderaktivitet.repository.WeatherActivityRepository;
import se.theflow.vaderaktivitet.repository.WeatherToCacheTablesRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationPath("/weatherActivityApi")
@Path("/v1.0")
@Consumes(MediaType.APPLICATION_JSON)   // under test
public class weatherActivityApi extends Application {

    // Inject repositorys
    @Inject
    private WeatherActivityRepository cr;

    @Inject
    private UserLogin userLogin;

    @Inject
    private WeatherToCacheTablesRepository weatherToCacheTablesRepository;



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
    @Path("/secured/listusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUsers() {
        return userLogin.getAllUsers();
    }

    @GET
    @Path("users/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    // id 1-4,
    // Return one user object
    public String getId(@PathParam("id") int id) {
        //return userLogin.findUserByUserName(id);
        return userLogin.findUserByUserName(id).getUserName();
    }

    @POST
    @Path("secured/createuser")
    public Response createNewUserAccount(Users users) {
        userLogin.createNewUser(users);

        return Response.ok().build();
    }



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
    /*@POST
    @Path("secured/updateparameters")
    public Response updateParameters(UpdateCacheParametersInDatabase updateCacheParametersInDatabase) {
        updateCacheParametersInDatabase.updateParameters();

        return Response.ok().build();
    }*/

    // Update parameters
    @GET
    @Path("secured/updategoteborg")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateGoteborg(UpdateCachePlaceParametersRepository updateCacheParametersInDatabase) {
        updateCacheParametersInDatabase.updateGoteborg(1,11,12,13);

        return "Update completed";
    }
}