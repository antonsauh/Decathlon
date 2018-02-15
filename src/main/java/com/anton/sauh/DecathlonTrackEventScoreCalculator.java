package com.anton.sauh;

/**
 * Created by AntonSauh
 */
public class DecathlonTrackEventScoreCalculator implements IDecathlonEventScoreCalculator {

    public int calculateScoreForEvent(double record, double[] abc) {
        return (int)(abc[0]* Math.pow((abc[1] - record), abc[2]));
    }
}
