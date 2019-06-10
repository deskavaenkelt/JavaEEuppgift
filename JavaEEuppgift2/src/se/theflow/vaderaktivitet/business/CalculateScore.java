package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.models.Place;

public class CalculateScore {

    //tabell i sql cachePlaceParameters
    //tabell i sql cacheScores


    private int tempDifference;
    private int vindDifference;
    private int cloudDifference;
    private int rainDifference;

    private int tempPoint;
    private int vindPoint;
    private int cloudPoint;
    private int rainPoint;

    public static void main(String[] args) {
        smhi.weatherFetcher(smhi.timeAdder(0), smhi.urlGenerator(Place.class.getName()));
        int tempNow = 1;
        int vindNow = 1;
        int cloudNow = 1;
        int rainNow = 1;

        int tempOptimal = 2;
        int vindOptimal = 2;
        int cloudOptimal = 2;
        int rainOptimal = 2;

        HighScoreTempVindRain(tempOptimal, tempNow);
        HighScoreTempVindRain(vindOptimal, vindNow);
        HighScoreTempVindRain(rainOptimal, rainNow);
        HighScoreCloud(cloudOptimal, cloudNow);
    }

    public static int HighScoreTempVindRain(int Optimal, int Now) {
        int Difference;
        int Point = 0;
        Difference = Optimal-Now;
        if(Difference == 0) {
            Point = 15;
        }else if(Difference == 1) {
            Point = 14;
        }else if(Difference == 2) {
            Point = 13;
        }else if(Difference == 3) {
            Point = 12;
        }else if(Difference == 4) {
            Point = 11;
        }else if(Difference == 5) {
            Point = 10;
        }else if(Difference == 6) {
            Point = 9;
        }else if(Difference == 7) {
            Point = 8;
        }else if(Difference == 8) {
            Point = 7;
        }else if(Difference == 9) {
            Point = 6;
        }else if(Difference == 10) {
            Point = 5;
        }else if(Difference == 11) {
            Point = 4;
        }else if(Difference == 12) {
            Point = 3;
        }else if(Difference == 13) {
            Point = 2;
        }else if(Difference == 14) {
            Point = 1;
        }else if(Difference < 15) {
            Point = 0;
        }
        return Point;
    }

    public static int HighScoreCloud(int Optimal, int Now) {
        int Difference;
        int Point = 0;
        Difference = Optimal-Now;
        if(Difference == 0) {
            Point = 15;
        }else if(Difference == 1) {
            Point = 13;
        }else if(Difference == 2) {
            Point = 11;
        }else if(Difference == 3) {
            Point = 9;
        }else if(Difference == 4) {
            Point = 7;
        }else if(Difference == 5) {
            Point = 5;
        }else if(Difference == 6) {
            Point = 3;
        }else if(Difference == 7) {
            Point = 1;
        }
        return Point;
    }

}
