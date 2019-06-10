package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.repository.CacheScoresRepository;

import javax.inject.Inject;

public class CacheScoresBl {

    // Inject Repository
    @Inject
    private CacheScoresRepository cacheScoresRepository;

    public void updateCacheScoreById(int id, float fishing, float outdoorSeating, float sunBathing, float volleyBall, float windSurfing) {

        // Göteborg day0 = id[1] , day5 = id[6]
        // Kungsbacka day0 = id[7] , day5 = id[12]
        // Åsa day0 = id[13] , day5 = id[18]
        // Varberg day0 = id[19] , day5 = id[24]
        // Falkenberg day0 = id[25] , day5 = id[30]
        cacheScoresRepository.updateScores(id, fishing, outdoorSeating, sunBathing, volleyBall, windSurfing);
    }

    public void updateCacheFishingById(int id, float fishing) {
        cacheScoresRepository.updateFishing(id, fishing);
    }

    public void updateCacheOutdoorSeatingById(int id, float outdoorSeating) {
        cacheScoresRepository.updateOutdoorSeating(id, outdoorSeating);
    }
    public void updateCacheSunBathingById(int id, float sunBathing) {
        cacheScoresRepository.updateSunBathing(id, sunBathing);
    }
    public void updateCacheVolleyBallById(int id, float volleyBall) {
        cacheScoresRepository.updateVolleyBall(id, volleyBall);
    }
    public void updateCacheWindSurfingById(int id, float windSurfing) {
        cacheScoresRepository.updateWindSurfing(id, windSurfing);
    }

}
