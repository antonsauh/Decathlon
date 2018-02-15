package com.anton.sauh;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class ContestantsTest {
    ArrayList<Contestant> contestantList = new ArrayList<Contestant>();

    @org.junit.Before
    public void setContestant() {
        Contestant contestant1 = new Contestant("Anton Sauh", 13.43, 4.80, 8.64, 1.50, 66.06, 19.05,
                24.89, 2.23, 33.48, 411.01);
        contestantList.add(contestant1);

    }

    @Test
    public void getContestants() throws Exception {
        assertEquals("Anton Sauh", contestantList.get(0).getName());
    }

    @Test
    public void setContestants() throws Exception {
        contestantList.clear();
        Contestant contestant1 = new Contestant("Tony Montana", 13.43, 4.80, 8.64, 1.50, 66.06, 19.05,
                24.89, 2.23, 33.48, 411.01);
        contestantList.add(contestant1);
        assertEquals("Tony Montana", contestantList.get(0).getName());
    }

}