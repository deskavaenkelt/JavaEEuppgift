package se.theflow.vaderaktivitet.business;

public class CalculateScore {



    public float HighScoreTempVindRain(float Optimal, float Now) {
        float Difference;
        float Point = 100;

        Difference = Optimal-Now;
        Difference = Difference * 10;

        for(int i = 0; i < Difference; i++) {
            Point --;
        }
        return Point;
    }

    public float HighScoreCloud(float Optimal, float Now) {
        float Difference;
        float Point = 100;
        
        Difference = Optimal-Now;

        for(int i = 0; i < Difference; i++) {
            Point = Point - 10;
        }
        return Point;
    }
}