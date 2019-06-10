package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.repository.WeatherOptimalRepository;
import javax.inject.Inject;

public class WeatherOptimalBl {

    // Inject Repository
    @Inject
    private WeatherOptimalRepository weatherOptimalRepository;

    public float[] getActivityById(int id) {

        System.out.println("Inside WeatherOptimalBl, method getActivityById call WeatherOptimalRepository");
        // Id 1-5
        return weatherOptimalRepository.getOptimalValuesForActivity(id);
    }
}
