package com.anton.sauh;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class DecathlonResultCalculatorTest {
    ArrayList<Contestant> contestantList = new ArrayList<Contestant>();
    DecathlonResultCalculator calc = new DecathlonResultCalculator();

    @org.junit.Before
    public void setContestant() {
        Contestant contestant1 = new Contestant("John Smith", 12.61, 500.0, 9.22, 150, 60.39, 16.43,
                21.60, 260, 35.81, 325.72);
        Contestant contestant2 = new Contestant("Jane Doe", 13.04, 453.0, 7.79, 155, 64.72, 18.74,
                24.20, 240, 28.20, 410.76);
        Contestant contestant3 = new Contestant("Jaan Lepp", 13.75, 484.0, 10.12, 150, 68.44, 19.18,
                30.85, 280, 33.88, 382.75);
        Contestant contestant4 = new Contestant("Foo Bar", 13.43, 435.0, 8.64, 150, 66.06, 19.05,
                24.89, 220, 33.48, 411.01);
        contestantList.add(contestant1);
        contestantList.add(contestant2);
        contestantList.add(contestant3);
        contestantList.add(contestant4);

    }
    @Test
    public void calculateScores() throws Exception {
        calc.calculateScores(contestantList);
        assertEquals(4200.0 ,contestantList.get(0).getScore(), 0);
        assertEquals(3199.0 ,contestantList.get(1).getScore(), 0);
        assertEquals(3494.0 ,contestantList.get(2).getScore(), 0);
        assertEquals(3099.0 ,contestantList.get(3).getScore(), 0);
    }
}