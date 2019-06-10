package se.theflow.vaderaktivitet.business;
import java.sql.*;
import javax.inject.Inject;

public class compromiseMagic {
    @Inject
    Smhi smhi;
    @Inject
    CalculateScore calculatescore;
    @Inject
    public void updateAllPoints(){
        //0 = fishing, 1 = outdoorsEating, 2 = sunBathing, 3 = volleyboll, 4 = vindsurfing
        String query = "SELECT * FROM weatherOptimal WHERE id = 1";
        Statement st =
        float tempFloatArray[] = new float[4];
        float celOptimalFishing =
        float celOptimal = 2;
        float windOptimal = 2;
        float cloudOptimal = 2;
        float rainOptimal = 2;
        for(int id = 0; id <= 5; id++)
        tempFloatArray = smhi.weatherFetcher(smhi.timeAdder(0), smhi.urlGenerator(id));
        float celPoints = calculatescore.HighScoreTempVindRain(celOptimal, tempFloatArray[0]);
        float cloudPoints = calculatescore.HighScoreCloud(cloudOptimal, tempFloatArray[1]);
        float windPoints = calculatescore.HighScoreTempVindRain(windOptimal, tempFloatArray[2]);
        float rainPoints = calculatescore.HighScoreTempVindRain(rainOptimal, tempFloatArray[3]);
    }
}
