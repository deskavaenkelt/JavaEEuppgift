package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.repository.UpdateCachePlaceParametersRepository;
import javax.inject.Inject;

public class UpdateCacheParametersInDatabase {

    // Inject Models
    @Inject
    private UpdateCachePlaceParametersRepository updateCachePlaceParameters;

    public void dummyGoteborg(){
        System.out.println("inside dummy Goteborg");
        updatePlace(1,2,3,4);
    }

    public void updatePlace(int id, int temperature, int cloud, int wind) {

        // Göteborg day0 = id[1] , day5 = id[6]
        // Kungsbacka day0 = id[7] , day5 = id[12]
        // Åsa day0 = id[13] , day5 = id[18]
        // Varberg day0 = id[19] , day5 = id[24]
        // Falkenberg day0 = id[25] , day5 = id[30]
        updateCachePlaceParameters.updatePlaces(id, temperature, cloud, wind);
    }
}