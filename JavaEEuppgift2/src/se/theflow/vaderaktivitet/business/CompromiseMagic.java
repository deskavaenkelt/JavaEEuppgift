package se.theflow.vaderaktivitet.business;

import javax.inject.Inject;

public class  CompromiseMagic {
    @Inject
    Smhi smhi;
    @Inject
    CalculateScore calculatescore;
    @Inject
    WeatherOptimalBl weatheroptimalbl;
    @Inject
    CacheScoresBl cachescoresbl;

    public void updateAllPoints() {
        //0 = fishing, 1 = outdoorsEating, 2 = sunBathing, 3 = volleyboll, 4 = vindsurfing
        for (int locId = 1; locId <= 5; locId++) {
            float tempFloatArray[] = new float[4];
            float tempOptimalArray[] = new float[4];
            float celPoints = 0;
            float cloudPoints = 0;
            float windPoints = 0;
            float rainPoints = 0;
            tempFloatArray = smhi.weatherFetcher(smhi.timeAdder(0), smhi.urlGenerator(locId));


            for (int id = 1; id <= 5; id++) {
                tempOptimalArray = weatheroptimalbl.getActivityById(id);

                float celOptimal = tempOptimalArray[0];
                float windOptimal = tempOptimalArray[1];
                float cloudOptimal = tempOptimalArray[2];
                float rainOptimal = tempOptimalArray[3];

                celPoints = calculatescore.HighScoreTempVindRain(celOptimal, tempFloatArray[0]);
                cloudPoints = calculatescore.HighScoreCloud(cloudOptimal, tempFloatArray[1]);
                windPoints = calculatescore.HighScoreTempVindRain(windOptimal, tempFloatArray[2]);
                rainPoints = calculatescore.HighScoreTempVindRain(rainOptimal, tempFloatArray[3]);
                float totalScore = celPoints + cloudPoints + windPoints + rainPoints;
                //göteborg
                if(id == 1 && locId == 1){
                    cachescoresbl.updateCacheFishingById(1, totalScore);
                }
                else if(id == 2 && locId == 1){
                    cachescoresbl.updateCacheOutdoorSeatingById(1, totalScore);
                }
                else if (id == 3 && locId == 1){
                    cachescoresbl.updateCacheSunBathingById(1, totalScore);
                }
                else if(id == 4 && locId == 1){
                    cachescoresbl.updateCacheVolleyBallById(1, totalScore);
                }
                else if(id == 5 && locId == 1){
                    cachescoresbl.updateCacheWindSurfingById(1, totalScore);
                }
                //Kungsbacka
                else if(id == 1 && locId == 2){
                    cachescoresbl.updateCacheFishingById(7, totalScore);
                }
                else if(id == 2 && locId == 2){
                    cachescoresbl.updateCacheOutdoorSeatingById(7, totalScore);
                }
                else if (id == 3 && locId == 2){
                    cachescoresbl.updateCacheSunBathingById(7, totalScore);
                }
                else if(id == 4 && locId == 2){
                    cachescoresbl.updateCacheVolleyBallById(7, totalScore);
                }
                else if(id == 5 && locId == 2){
                    cachescoresbl.updateCacheWindSurfingById(7, totalScore);
                }
                //åsa
                else if(id == 1 && locId == 3){
                    cachescoresbl.updateCacheFishingById(13, totalScore);
                }
                else if(id == 2 && locId == 3){
                    cachescoresbl.updateCacheOutdoorSeatingById(13, totalScore);
                }
                else if (id == 3 && locId == 3){
                    cachescoresbl.updateCacheSunBathingById(13, totalScore);
                }
                else if(id == 4 && locId == 3){
                    cachescoresbl.updateCacheVolleyBallById(13, totalScore);
                }
                else if(id == 5 && locId == 3){
                    cachescoresbl.updateCacheWindSurfingById(13, totalScore);
                }
                //Varberg
                else if(id == 1 && locId == 4){
                    cachescoresbl.updateCacheFishingById(19, totalScore);
                }
                else if(id == 2 && locId == 4){
                    cachescoresbl.updateCacheOutdoorSeatingById(19, totalScore);
                }
                else if (id == 3 && locId == 4){
                    cachescoresbl.updateCacheSunBathingById(19, totalScore);
                }
                else if(id == 4 && locId == 4){
                    cachescoresbl.updateCacheVolleyBallById(19, totalScore);
                }
                else if(id == 5 && locId == 4){
                    cachescoresbl.updateCacheWindSurfingById(19, totalScore);
                }
                //falkenberg
                else if(id == 1 && locId == 5){
                    cachescoresbl.updateCacheFishingById(25, totalScore);
                }
                else if(id == 2 && locId == 5){
                    cachescoresbl.updateCacheOutdoorSeatingById(25, totalScore);
                }
                else if (id == 3 && locId == 5){
                    cachescoresbl.updateCacheSunBathingById(25, totalScore);
                }
                else if(id == 4 && locId == 5){
                    cachescoresbl.updateCacheVolleyBallById(25, totalScore);
                }
                else if(id == 5 && locId == 5){
                    cachescoresbl.updateCacheWindSurfingById(25, totalScore);
                }
            }

        }
    }
}
