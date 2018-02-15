package com.anton.sauh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class DecathlonTrackEventScoreCalculatorTest {
    @Test
    public void calculateScoreForEvent() throws Exception {
        double result = 10.50;
        double[] abc = {3.0, 1.0, 2.0};
        DecathlonTrackEventScoreCalculator calculator = new DecathlonTrackEventScoreCalculator();
        assertEquals(270, calculator.calculateScoreForEvent(result, abc), 0);
    }

}