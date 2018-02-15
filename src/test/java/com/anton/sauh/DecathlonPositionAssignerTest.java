package com.anton.sauh;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class DecathlonPositionAssignerTest {
    ArrayList<Contestant> contestantList = new ArrayList<Contestant>();
    DecathlonPositionAssigner calc = new DecathlonPositionAssigner();

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
    public void assignPositionsForDifferentScores() throws Exception {
        contestantList.get(0).setScore(500);
        contestantList.get(1).setScore(1000);
        contestantList.get(2).setScore(1500);
        contestantList.get(3).setScore(2000);
        calc.assignPositions(contestantList);
        assertEquals("1", contestantList.get(3).getPosition());
        assertEquals("2", contestantList.get(2).getPosition());
        assertEquals("3", contestantList.get(1).getPosition());
        assertEquals("4", contestantList.get(0).getPosition());
    }
    @Test
    public void assignPositionsForSameScores() throws Exception {
        contestantList.get(0).setScore(1000);
        contestantList.get(1).setScore(1000);
        contestantList.get(2).setScore(1000);
        contestantList.get(3).setScore(1000);
        calc.assignPositions(contestantList);
        assertEquals("1-4", contestantList.get(2).getPosition());
        assertEquals("1-4", contestantList.get(1).getPosition());
        assertEquals("1-4", contestantList.get(0).getPosition());
        assertEquals("1-4", contestantList.get(3).getPosition());
    }
    @Test
    public void assignPositionsEndingDuplicate() throws Exception {
        contestantList.get(0).setScore(500);
        contestantList.get(1).setScore(1000);
        contestantList.get(2).setScore(1000);
        contestantList.get(3).setScore(1000);
        calc.assignPositions(contestantList);
        assertEquals("1-3", contestantList.get(2).getPosition());
        assertEquals("1-3", contestantList.get(1).getPosition());
        assertEquals("1-3", contestantList.get(3).getPosition());
        assertEquals("4", contestantList.get(0).getPosition());
    }
    @Test
    public void assignPositionsStartingDuplicate() throws Exception {
        contestantList.get(0).setScore(1000);
        contestantList.get(1).setScore(1000);
        contestantList.get(2).setScore(2000);
        contestantList.get(3).setScore(3000);
        calc.assignPositions(contestantList);
        assertEquals("2", contestantList.get(2).getPosition());
        assertEquals("3-4", contestantList.get(1).getPosition());
        assertEquals("3-4", contestantList.get(0).getPosition());
        assertEquals("1", contestantList.get(3).getPosition());
    }
    @Test
    public void assignPositionsMiddleDuplicate() throws Exception {
        contestantList.get(0).setScore(1000);
        contestantList.get(1).setScore(2000);
        contestantList.get(2).setScore(2000);
        contestantList.get(3).setScore(3000);
        calc.assignPositions(contestantList);
        assertEquals("2-3", contestantList.get(2).getPosition());
        assertEquals("2-3", contestantList.get(1).getPosition());
        assertEquals("4", contestantList.get(0).getPosition());
        assertEquals("1", contestantList.get(3).getPosition());
    }
    @Test
    public void assignPositionsMultipleDuplicates() throws Exception {
        contestantList.get(0).setScore(1000);
        contestantList.get(1).setScore(1000);
        contestantList.get(2).setScore(2000);
        contestantList.get(3).setScore(2000);
        calc.assignPositions(contestantList);
        assertEquals("1-2", contestantList.get(2).getPosition());
        assertEquals("3-4", contestantList.get(1).getPosition());
        assertEquals("3-4", contestantList.get(0).getPosition());
        assertEquals("1-2", contestantList.get(3).getPosition());
    }


    }
