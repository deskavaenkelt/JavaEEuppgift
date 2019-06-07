package se.theflow.vaderaktivitet.api;

//import se.theflow.vaderaktivitet.business.RequestsFromApi;

import org.json.JSONArray;
import org.json.JSONObject;
import se.theflow.vaderaktivitet.models.Place;
import se.theflow.vaderaktivitet.models.Users;
import se.theflow.vaderaktivitet.repository.UserLogin;
import se.theflow.vaderaktivitet.repository.WeatherActivityRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/weatherActivityApi")
@Path("/v1.0")
public class weatherActivityApi extends Application {

    @Inject
    private WeatherActivityRepository cr;

    @Inject
    private UserLogin userLogin;

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
    @Produces(MediaType.APPLICATION_JSON)
    // id 1-4
    public Users getId(@PathParam("id") int id) {
        return userLogin.findUserByUserName(id);
    }

    @GET
    @Path("username/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    // id 1-4
    public String getNameById(@PathParam("id") int id) {
        return userLogin.findUserByUserIdReturnName(id);
    }
    @GET
    @Path("usersalt/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    // id 1-4
    public String getSaltById(@PathParam("id") int id) {
        return userLogin.findUserByUserIdReturnSalt(id);
    }
    @GET
    @Path("userpassword/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    // id 1-4
    public String getPasswordById(@PathParam("id") int id) {
        return userLogin.findUserByUserIdReturnPassword(id);
    }

}