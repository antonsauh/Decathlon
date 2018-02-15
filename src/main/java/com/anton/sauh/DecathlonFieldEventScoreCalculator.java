package com.anton.sauh;

/**
 * Created by AntonSauh
 */
public class DecathlonFieldEventScoreCalculator implements IDecathlonEventScoreCalculator {

    public int calculateScoreForEvent(double record, double[] abc) {
        return (int)(abc[0]* Math.pow((record - abc[1]), abc[2]));
    }
}
