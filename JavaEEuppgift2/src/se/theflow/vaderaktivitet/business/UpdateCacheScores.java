package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.repository.CacheScoresRepository;

import javax.inject.Inject;

public class UpdateCacheScores {

    // Inject Repository
    @Inject
    private CacheScoresRepository cacheScoresRepository;

    public void updateCacheScoreById(int id, int fishing, int outdoorSeating, int sunBathing, int volleyBall, int windSurfing) {

        // Göteborg day0 = id[1] , day5 = id[6]
        // Kungsbacka day0 = id[7] , day5 = id[12]
        // Åsa day0 = id[13] , day5 = id[18]
        // Varberg day0 = id[19] , day5 = id[24]
        // Falkenberg day0 = id[25] , day5 = id[30]
        cacheScoresRepository.updateScores(id, fishing, outdoorSeating, sunBathing, volleyBall, windSurfing);
    }
}
