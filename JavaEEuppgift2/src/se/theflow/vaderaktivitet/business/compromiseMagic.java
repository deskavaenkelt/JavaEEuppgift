package se.theflow.vaderaktivitet.business;

import javax.inject.Inject;

public class compromiseMagic {
    @Inject
    Smhi smhi;
    @Inject
    CalculateScore calculatescore;
    public void updateAllPoints(){
        float tempFloatArray[] = new float[4];
        int celOptimal = 2;
        int vindOptimal = 2;
        int cloudOptimal = 2;
        int rainOptimal = 2;
        for(int id = 0; id <= 5; id++)
        tempFloatArray = smhi.weatherFetcher(smhi.timeAdder(0), smhi.urlGenerator(id));
        floa

    }
}
