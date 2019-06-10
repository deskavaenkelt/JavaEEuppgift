package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.repository.CacheScoresRepository;
import se.theflow.vaderaktivitet.repository.WeatherOptimalRepository;

import javax.inject.Inject;

public class WeatherOptimalBl {

    // Inject Repository
    @Inject
    private WeatherOptimalRepository weatherOptimalRepository;

    public float[] getActivityById(int activity) {

        // Activity 0-4
        return weatherOptimalRepository.getOptimalValuesForActivity(activity);
    }
}
