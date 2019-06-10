package se.theflow.vaderaktivitet.business;
import java.sql.*;
import javax.inject.Inject;

public class CompromiseMagic {
    @Inject
    Smhi smhi;
    @Inject
    CalculateScore calculatescore;
    @Inject
    WeatherOptimalBl weatheroptimalbl;
    public void updateAllPoints(){
        //0 = fishing, 1 = outdoorsEating, 2 = sunBathing, 3 = volleyboll, 4 = vindsurfing
        for(int id = 0; id <= 5; id++){
        weatheroptimalbl.getActivityById(1);
        float tempFloatArray[] = new float[4];
        float tempOptimalArray[] = new float[4];
        tempOptimalArray = weatheroptimalbl.getActivityById(id);
        float celOptimal = tempOptimalArray[0];
        float windOptimal = tempOptimalArray[1];
        float cloudOptimal = tempOptimalArray[2];
        float rainOptimal = tempOptimalArray[3];
        tempFloatArray = smhi.weatherFetcher(smhi.timeAdder(0), smhi.urlGenerator(id));
        float celPoints = calculatescore.HighScoreTempVindRain(celOptimal, tempFloatArray[0]);
        float cloudPoints = calculatescore.HighScoreCloud(cloudOptimal, tempFloatArray[1]);
        float windPoints = calculatescore.HighScoreTempVindRain(windOptimal, tempFloatArray[2]);
        float rainPoints = calculatescore.HighScoreTempVindRain(rainOptimal, tempFloatArray[3]);
    }
    }
}
