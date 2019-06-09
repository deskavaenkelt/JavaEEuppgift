package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;
import se.theflow.vaderaktivitet.repository.UpdateCachePlaceParametersRepository;
import se.theflow.vaderaktivitet.repository.WeatherToCacheTablesRepository;

import javax.inject.Inject;

public class UpdateCacheParametersInDatabase {

    // Inject Models
    @Inject
    private UpdateCachePlaceParametersRepository updateCachePlaceParameters;
    //private WeatherToCacheTablesRepository weatherToCacheTablesRepository;

    public void updateGoteborg() {
        int temperature = 10;
        int cloud = 11;
        int wind = 12;

        // Göteborg id 1-6
        for (int i = 1; i < 7; i++) {
            updateCachePlaceParameters.updateGoteborg(i, temperature, cloud, wind);
            temperature++;
            cloud++;
            wind++;

        }
    }

    /*public void updateParameters(int id) {
        weatherToCacheTablesRepository.setCachePlaceParameters(1, 0, 10, 11, 12);
        weatherToCacheTablesRepository.findPlaceByPlaceIdAndUpdate(1,0);

        CachePlaceParametersModel cachePlaceParametersModel = weatherToCacheTablesRepository.findPlace(id);
        cachePlaceParametersModel.getDay();

    }*/
}
