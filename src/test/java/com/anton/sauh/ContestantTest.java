package com.anton.sauh;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class ContestantTest {
    private Contestant contestant;

    @org.junit.Before
    public void setContestant() {
        contestant = new Contestant("Anton Sauh", 13.43, 4.80, 8.64, 1.50, 66.06, 19.05,
                24.89, 2.23, 33.48, 411.01);
        contestant.setPosition("1");
        contestant.setScore(500);
    }

    @org.junit.Test
    public void getScore() throws Exception {
        assertEquals(500, contestant.getScore(), 0);
    }

    @org.junit.Test
    public void setScore() throws Exception {
        contestant.setScore(1000);
        assertEquals(1000, contestant.getScore(), 0);
    }

    @org.junit.Test
    public void getLongJump() throws Exception {
        assertEquals(4.80, contestant.getLongJump(), 0);
    }

    @org.junit.Test
    public void getShotPut() throws Exception {
        assertEquals(8.64, contestant.getShotPut(), 0);
    }

    @org.junit.Test
    public void getHighJump() throws Exception {
        assertEquals(1.50, contestant.getHighJump(), 0);
    }

    @org.junit.Test
    public void getFourHundredRun() throws Exception {
        assertEquals(66.06, contestant.getFourHundredRun(), 0);
    }

    @org.junit.Test
    public void getHurdlesRun() throws Exception {
        assertEquals(19.05, contestant.getHurdlesRun(), 0);
    }

    @org.junit.Test
    public void getDiscusThrow() throws Exception {
        assertEquals(24.89, contestant.getDiscusThrow(), 0);
    }

    @org.junit.Test
    public void getPoleVault() throws Exception {
        assertEquals(2.23, contestant.getPoleVault(), 0);
    }

    @org.junit.Test
    public void getJavelinThrow() throws Exception {
        assertEquals(33.48, contestant.getJavelinThrow(), 0);
    }

    @org.junit.Test
    public void getLongRun() throws Exception {
        assertEquals(411.01, contestant.getLongRun(), 0);
    }

    @org.junit.Test
    public void getPosition() throws Exception {
        assertEquals("1", contestant.getPosition());
    }

    @org.junit.Test
    public void setPosition() throws Exception {
        contestant.setPosition("2");
        assertEquals("2", contestant.getPosition());
    }

    @org.junit.Test
    public void getHundredRun() throws Exception {
        assertEquals(13.43, contestant.getHundredRun(), 0);
    }

    @org.junit.Test
    public void getName() throws Exception {
        assertEquals("Anton Sauh", contestant.getName());
    }

}