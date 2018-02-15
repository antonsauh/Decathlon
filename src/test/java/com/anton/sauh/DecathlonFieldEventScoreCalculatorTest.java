package com.anton.sauh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class DecathlonFieldEventScoreCalculatorTest {
    @Test
    public void calculateScoreForEvent() throws Exception {
        double result = 10.0;
        double[] abc = {1.0, 2.0, 3.0};
        DecathlonFieldEventScoreCalculator calculator = new DecathlonFieldEventScoreCalculator();
        assertEquals(512.0, calculator.calculateScoreForEvent(result, abc), 0);
    }


}