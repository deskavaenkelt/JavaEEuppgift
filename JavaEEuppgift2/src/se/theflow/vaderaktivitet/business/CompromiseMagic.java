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
    UpdateCacheScores updatecachescores;

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
                if(id == 1){
                    
                }

            }
            float totalScore = celPoints + cloudPoints + windPoints + rainPoints;
        }
    }
}