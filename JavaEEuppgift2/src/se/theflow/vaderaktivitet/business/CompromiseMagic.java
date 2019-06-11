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
        for (int timeAdder = 0; timeAdder <= 5; timeAdder ++) {
            int gigaint = 0;
            if(timeAdder>1){
                gigaint =+ 12;
            }
            for (int locId = 1; locId <= 5; locId++) {
                float tempFloatArray[] = new float[4];
                float tempOptimalArray[] = new float[4];
                float celPoints = 0;
                float cloudPoints = 0;
                float windPoints = 0;
                float rainPoints = 0;
                if(timeAdder < 2) {
                    tempFloatArray = smhi.weatherFetcher(smhi.timeAdder(gigaint), smhi.urlGenerator(locId));
                }
                else if(timeAdder == 2){
                    tempFloatArray = smhi.weatherFetcher(smhi.dayAdder(2), smhi.urlGenerator(locId));
                }
                else if(timeAdder == 3){
                    tempFloatArray = smhi.weatherFetcher(smhi.dayAdder(3), smhi.urlGenerator(locId));
                }
                else if(timeAdder == 4){
                    tempFloatArray = smhi.weatherFetcher(smhi.dayAdder(4), smhi.urlGenerator(locId));
                }

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
                    if (id == 1 && locId == 1) {
                        cachescoresbl.updateCacheFishingById(1, totalScore);
                    } else if (id == 2 && locId == 1) {
                        cachescoresbl.updateCacheOutdoorSeatingById(1, totalScore);
                    } else if (id == 3 && locId == 1) {
                        cachescoresbl.updateCacheSunBathingById(1, totalScore);
                    } else if (id == 4 && locId == 1) {
                        cachescoresbl.updateCacheVolleyBallById(1, totalScore);
                    } else if (id == 5 && locId == 1) {
                        cachescoresbl.updateCacheWindSurfingById(1, totalScore);
                    }
                    //Kungsbacka
                    else if (id == 1 && locId == 2) {
                        cachescoresbl.updateCacheFishingById(7, totalScore);
                    } else if (id == 2 && locId == 2) {
                        cachescoresbl.updateCacheOutdoorSeatingById(7, totalScore);
                    } else if (id == 3 && locId == 2) {
                        cachescoresbl.updateCacheSunBathingById(7, totalScore);
                    } else if (id == 4 && locId == 2) {
                        cachescoresbl.updateCacheVolleyBallById(7, totalScore);
                    } else if (id == 5 && locId == 2) {
                        cachescoresbl.updateCacheWindSurfingById(7, totalScore);
                    }
                    //åsa
                    else if (id == 1 && locId == 3) {
                        cachescoresbl.updateCacheFishingById(13, totalScore);
                    } else if (id == 2 && locId == 3) {
                        cachescoresbl.updateCacheOutdoorSeatingById(13, totalScore);
                    } else if (id == 3 && locId == 3) {
                        cachescoresbl.updateCacheSunBathingById(13, totalScore);
                    } else if (id == 4 && locId == 3) {
                        cachescoresbl.updateCacheVolleyBallById(13, totalScore);
                    } else if (id == 5 && locId == 3) {
                        cachescoresbl.updateCacheWindSurfingById(13, totalScore);
                    }
                    //Varberg
                    else if (id == 1 && locId == 4) {
                        cachescoresbl.updateCacheFishingById(19, totalScore);
                    } else if (id == 2 && locId == 4) {
                        cachescoresbl.updateCacheOutdoorSeatingById(19, totalScore);
                    } else if (id == 3 && locId == 4) {
                        cachescoresbl.updateCacheSunBathingById(19, totalScore);
                    } else if (id == 4 && locId == 4) {
                        cachescoresbl.updateCacheVolleyBallById(19, totalScore);
                    } else if (id == 5 && locId == 4) {
                        cachescoresbl.updateCacheWindSurfingById(19, totalScore);
                    }
                    //falkenberg
                    else if (id == 1 && locId == 5) {
                        cachescoresbl.updateCacheFishingById(25, totalScore);
                    } else if (id == 2 && locId == 5) {
                        cachescoresbl.updateCacheOutdoorSeatingById(25, totalScore);
                    } else if (id == 3 && locId == 5) {
                        cachescoresbl.updateCacheSunBathingById(25, totalScore);
                    } else if (id == 4 && locId == 5) {
                        cachescoresbl.updateCacheVolleyBallById(25, totalScore);
                    } else if (id == 5 && locId == 5) {
                        cachescoresbl.updateCacheWindSurfingById(25, totalScore);
                    }
                    //göteborg
                    if (id == 1 && locId == 1 && timeAdder == 1) {
                        cachescoresbl.updateCacheFishingById(2, totalScore);
                    } else if (id == 2 && locId == 1 && timeAdder == 1) {
                        cachescoresbl.updateCacheOutdoorSeatingById(2, totalScore);
                    } else if (id == 3 && locId == 1 && timeAdder == 1) {
                        cachescoresbl.updateCacheSunBathingById(2, totalScore);
                    } else if (id == 4 && locId == 1 && timeAdder == 1) {
                        cachescoresbl.updateCacheVolleyBallById(2, totalScore);
                    } else if (id == 5 && locId == 1 && timeAdder == 1) {
                        cachescoresbl.updateCacheWindSurfingById(2, totalScore);
                    }
                    //Kungsbacka
                    else if (id == 1 && locId == 2 && timeAdder == 1) {
                        cachescoresbl.updateCacheFishingById(8, totalScore);
                    } else if (id == 2 && locId == 2 && timeAdder == 1) {
                        cachescoresbl.updateCacheOutdoorSeatingById(8, totalScore);
                    } else if (id == 3 && locId == 2 && timeAdder == 1) {
                        cachescoresbl.updateCacheSunBathingById(8, totalScore);
                    } else if (id == 4 && locId == 2 && timeAdder == 1) {
                        cachescoresbl.updateCacheVolleyBallById(8, totalScore);
                    } else if (id == 5 && locId == 2 && timeAdder == 1) {
                        cachescoresbl.updateCacheWindSurfingById(8, totalScore);
                    }
                    //åsa
                    else if (id == 1 && locId == 3 && timeAdder == 1) {
                        cachescoresbl.updateCacheFishingById(14, totalScore);
                    } else if (id == 2 && locId == 3 && timeAdder == 1) {
                        cachescoresbl.updateCacheOutdoorSeatingById(14, totalScore);
                    } else if (id == 3 && locId == 3 && timeAdder == 1) {
                        cachescoresbl.updateCacheSunBathingById(14, totalScore);
                    } else if (id == 4 && locId == 3 && timeAdder == 1) {
                        cachescoresbl.updateCacheVolleyBallById(14, totalScore);
                    } else if (id == 5 && locId == 3 && timeAdder == 1) {
                        cachescoresbl.updateCacheWindSurfingById(14, totalScore);
                    }
                    //Varberg
                    else if (id == 1 && locId == 4 && timeAdder == 1) {
                        cachescoresbl.updateCacheFishingById(20, totalScore);
                    } else if (id == 2 && locId == 4 && timeAdder == 1) {
                        cachescoresbl.updateCacheOutdoorSeatingById(20, totalScore);
                    } else if (id == 3 && locId == 4 && timeAdder == 1) {
                        cachescoresbl.updateCacheSunBathingById(20, totalScore);
                    } else if (id == 4 && locId == 4 && timeAdder == 1) {
                        cachescoresbl.updateCacheVolleyBallById(20, totalScore);
                    } else if (id == 5 && locId == 4 && timeAdder == 1) {
                        cachescoresbl.updateCacheWindSurfingById(20, totalScore);
                    }
                    //falkenberg
                    else if (id == 1 && locId == 5 && timeAdder == 1) {
                        cachescoresbl.updateCacheFishingById(26, totalScore);
                    } else if (id == 2 && locId == 5 && timeAdder == 1) {
                        cachescoresbl.updateCacheOutdoorSeatingById(26, totalScore);
                    } else if (id == 3 && locId == 5 && timeAdder == 1) {
                        cachescoresbl.updateCacheSunBathingById(26, totalScore);
                    } else if (id == 4 && locId == 5 && timeAdder == 1) {
                        cachescoresbl.updateCacheVolleyBallById(26, totalScore);
                    } else if (id == 5 && locId == 5 && timeAdder == 1) {
                        cachescoresbl.updateCacheWindSurfingById(26, totalScore);
                    }
                    //göteborg
                    if (id == 1 && locId == 1 && timeAdder == 2) {
                        cachescoresbl.updateCacheFishingById(3, totalScore);
                    } else if (id == 2 && locId == 1 && timeAdder == 2) {
                        cachescoresbl.updateCacheOutdoorSeatingById(3, totalScore);
                    } else if (id == 3 && locId == 1 && timeAdder == 2) {
                        cachescoresbl.updateCacheSunBathingById(3, totalScore);
                    } else if (id == 4 && locId == 1 && timeAdder == 2) {
                        cachescoresbl.updateCacheVolleyBallById(3, totalScore);
                    } else if (id == 5 && locId == 1 && timeAdder == 2) {
                        cachescoresbl.updateCacheWindSurfingById(3, totalScore);
                    }
                    //Kungsbacka
                    else if (id == 1 && locId == 2 && timeAdder == 2) {
                        cachescoresbl.updateCacheFishingById(9, totalScore);
                    } else if (id == 2 && locId == 2 && timeAdder == 2) {
                        cachescoresbl.updateCacheOutdoorSeatingById(9, totalScore);
                    } else if (id == 3 && locId == 2 && timeAdder == 2) {
                        cachescoresbl.updateCacheSunBathingById(9, totalScore);
                    } else if (id == 4 && locId == 2 && timeAdder == 2) {
                        cachescoresbl.updateCacheVolleyBallById(9, totalScore);
                    } else if (id == 5 && locId == 2 && timeAdder == 2) {
                        cachescoresbl.updateCacheWindSurfingById(9, totalScore);
                    }
                    //åsa
                    else if (id == 1 && locId == 3 && timeAdder == 2) {
                        cachescoresbl.updateCacheFishingById(15, totalScore);
                    } else if (id == 2 && locId == 3 && timeAdder == 2) {
                        cachescoresbl.updateCacheOutdoorSeatingById(15, totalScore);
                    } else if (id == 3 && locId == 3 && timeAdder == 2) {
                        cachescoresbl.updateCacheSunBathingById(15, totalScore);
                    } else if (id == 4 && locId == 3 && timeAdder == 2) {
                        cachescoresbl.updateCacheVolleyBallById(15, totalScore);
                    } else if (id == 5 && locId == 3 && timeAdder == 2) {
                        cachescoresbl.updateCacheWindSurfingById(15, totalScore);
                    }
                    //Varberg
                    else if (id == 1 && locId == 4 && timeAdder == 2) {
                        cachescoresbl.updateCacheFishingById(21, totalScore);
                    } else if (id == 2 && locId == 4 && timeAdder == 2) {
                        cachescoresbl.updateCacheOutdoorSeatingById(21, totalScore);
                    } else if (id == 3 && locId == 4 && timeAdder == 2) {
                        cachescoresbl.updateCacheSunBathingById(21, totalScore);
                    } else if (id == 4 && locId == 4 && timeAdder == 2) {
                        cachescoresbl.updateCacheVolleyBallById(21, totalScore);
                    } else if (id == 5 && locId == 4 && timeAdder == 2) {
                        cachescoresbl.updateCacheWindSurfingById(21, totalScore);
                    }
                    //falkenberg
                    else if (id == 1 && locId == 5 && timeAdder == 2) {
                        cachescoresbl.updateCacheFishingById(27, totalScore);
                    } else if (id == 2 && locId == 5 && timeAdder == 2) {
                        cachescoresbl.updateCacheOutdoorSeatingById(27, totalScore);
                    } else if (id == 3 && locId == 5 && timeAdder == 2) {
                        cachescoresbl.updateCacheSunBathingById(27, totalScore);
                    } else if (id == 4 && locId == 5 && timeAdder == 2) {
                        cachescoresbl.updateCacheVolleyBallById(27, totalScore);
                    } else if (id == 5 && locId == 5 && timeAdder == 2) {
                        cachescoresbl.updateCacheWindSurfingById(27, totalScore);
                    }
                    //göteborg
                    if (id == 1 && locId == 1 && timeAdder == 3) {
                        cachescoresbl.updateCacheFishingById(4, totalScore);
                    } else if (id == 2 && locId == 1 && timeAdder == 3) {
                        cachescoresbl.updateCacheOutdoorSeatingById(4, totalScore);
                    } else if (id == 3 && locId == 1 && timeAdder == 3) {
                        cachescoresbl.updateCacheSunBathingById(4, totalScore);
                    } else if (id == 4 && locId == 1 && timeAdder == 3) {
                        cachescoresbl.updateCacheVolleyBallById(4, totalScore);
                    } else if (id == 5 && locId == 1 && timeAdder == 3) {
                        cachescoresbl.updateCacheWindSurfingById(4, totalScore);
                    }
                    //Kungsbacka
                    else if (id == 1 && locId == 2 && timeAdder == 3) {
                        cachescoresbl.updateCacheFishingById(10, totalScore);
                    } else if (id == 2 && locId == 2 && timeAdder == 3) {
                        cachescoresbl.updateCacheOutdoorSeatingById(10, totalScore);
                    } else if (id == 3 && locId == 2 && timeAdder == 3) {
                        cachescoresbl.updateCacheSunBathingById(10, totalScore);
                    } else if (id == 4 && locId == 2 && timeAdder == 3) {
                        cachescoresbl.updateCacheVolleyBallById(10, totalScore);
                    } else if (id == 5 && locId == 2 && timeAdder == 3) {
                        cachescoresbl.updateCacheWindSurfingById(10, totalScore);
                    }
                    //åsa
                    else if (id == 1 && locId == 3 && timeAdder == 3) {
                        cachescoresbl.updateCacheFishingById(16, totalScore);
                    } else if (id == 2 && locId == 3 && timeAdder == 3) {
                        cachescoresbl.updateCacheOutdoorSeatingById(16, totalScore);
                    } else if (id == 3 && locId == 3 && timeAdder == 3) {
                        cachescoresbl.updateCacheSunBathingById(16, totalScore);
                    } else if (id == 4 && locId == 3 && timeAdder == 3) {
                        cachescoresbl.updateCacheVolleyBallById(16, totalScore);
                    } else if (id == 5 && locId == 3 && timeAdder == 3) {
                        cachescoresbl.updateCacheWindSurfingById(16, totalScore);
                    }
                    //Varberg
                    else if (id == 1 && locId == 4 && timeAdder == 3) {
                        cachescoresbl.updateCacheFishingById(22, totalScore);
                    } else if (id == 2 && locId == 4 && timeAdder == 3) {
                        cachescoresbl.updateCacheOutdoorSeatingById(22, totalScore);
                    } else if (id == 3 && locId == 4 && timeAdder == 3) {
                        cachescoresbl.updateCacheSunBathingById(22, totalScore);
                    } else if (id == 4 && locId == 4 && timeAdder == 3) {
                        cachescoresbl.updateCacheVolleyBallById(22, totalScore);
                    } else if (id == 5 && locId == 4 && timeAdder == 3) {
                        cachescoresbl.updateCacheWindSurfingById(22, totalScore);
                    }
                    //falkenberg
                    else if (id == 1 && locId == 5 && timeAdder == 3) {
                        cachescoresbl.updateCacheFishingById(28, totalScore);
                    } else if (id == 2 && locId == 5 && timeAdder == 3) {
                        cachescoresbl.updateCacheOutdoorSeatingById(28, totalScore);
                    } else if (id == 3 && locId == 5 && timeAdder == 3) {
                        cachescoresbl.updateCacheSunBathingById(28, totalScore);
                    } else if (id == 4 && locId == 5 && timeAdder == 3) {
                        cachescoresbl.updateCacheVolleyBallById(28, totalScore);
                    } else if (id == 5 && locId == 5 && timeAdder == 3) {
                        cachescoresbl.updateCacheWindSurfingById(28, totalScore);
                    }
                    //göteborg
                    if (id == 1 && locId == 1 && timeAdder == 4) {
                        cachescoresbl.updateCacheFishingById(5, totalScore);
                    } else if (id == 2 && locId == 1 && timeAdder == 4) {
                        cachescoresbl.updateCacheOutdoorSeatingById(5, totalScore);
                    } else if (id == 3 && locId == 1 && timeAdder == 4) {
                        cachescoresbl.updateCacheSunBathingById(5, totalScore);
                    } else if (id == 4 && locId == 1 && timeAdder == 4) {
                        cachescoresbl.updateCacheVolleyBallById(5, totalScore);
                    } else if (id == 5 && locId == 1 && timeAdder == 4) {
                        cachescoresbl.updateCacheWindSurfingById(5, totalScore);
                    }
                    //Kungsbacka
                    else if (id == 1 && locId == 2 && timeAdder == 4) {
                        cachescoresbl.updateCacheFishingById(11, totalScore);
                    } else if (id == 2 && locId == 2 && timeAdder == 4) {
                        cachescoresbl.updateCacheOutdoorSeatingById(11, totalScore);
                    } else if (id == 3 && locId == 2 && timeAdder == 4) {
                        cachescoresbl.updateCacheSunBathingById(11, totalScore);
                    } else if (id == 4 && locId == 2 && timeAdder == 4) {
                        cachescoresbl.updateCacheVolleyBallById(11, totalScore);
                    } else if (id == 5 && locId == 2 && timeAdder == 4) {
                        cachescoresbl.updateCacheWindSurfingById(11, totalScore);
                    }
                    //åsa
                    else if (id == 1 && locId == 3 && timeAdder == 4) {
                        cachescoresbl.updateCacheFishingById(17, totalScore);
                    } else if (id == 2 && locId == 3 && timeAdder == 4) {
                        cachescoresbl.updateCacheOutdoorSeatingById(17, totalScore);
                    } else if (id == 3 && locId == 3 && timeAdder == 4) {
                        cachescoresbl.updateCacheSunBathingById(17, totalScore);
                    } else if (id == 4 && locId == 3 && timeAdder == 4) {
                        cachescoresbl.updateCacheVolleyBallById(17, totalScore);
                    } else if (id == 5 && locId == 3 && timeAdder == 4) {
                        cachescoresbl.updateCacheWindSurfingById(17, totalScore);
                    }
                    //Varberg
                    else if (id == 1 && locId == 4 && timeAdder == 4) {
                        cachescoresbl.updateCacheFishingById(23, totalScore);
                    } else if (id == 2 && locId == 4 && timeAdder == 4) {
                        cachescoresbl.updateCacheOutdoorSeatingById(23, totalScore);
                    } else if (id == 3 && locId == 4 && timeAdder == 4) {
                        cachescoresbl.updateCacheSunBathingById(23, totalScore);
                    } else if (id == 4 && locId == 4 && timeAdder == 4) {
                        cachescoresbl.updateCacheVolleyBallById(23, totalScore);
                    } else if (id == 5 && locId == 4 && timeAdder == 4) {
                        cachescoresbl.updateCacheWindSurfingById(23, totalScore);
                    }
                    //falkenberg
                    else if (id == 1 && locId == 5 && timeAdder == 4) {
                        cachescoresbl.updateCacheFishingById(28, totalScore);
                    } else if (id == 2 && locId == 5 && timeAdder == 4) {
                        cachescoresbl.updateCacheOutdoorSeatingById(28, totalScore);
                    } else if (id == 3 && locId == 5 && timeAdder == 4) {
                        cachescoresbl.updateCacheSunBathingById(28, totalScore);
                    } else if (id == 4 && locId == 5 && timeAdder == 4) {
                        cachescoresbl.updateCacheVolleyBallById(28, totalScore);
                    } else if (id == 5 && locId == 5 && timeAdder == 4) {
                        cachescoresbl.updateCacheWindSurfingById(28, totalScore);
                    }
                }

            }
        }
    }
}
