package com.anton.sauh;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by AntonSauh
 */
public class CsvReaderTest {

    IReader reader = new CsvReader();
    ArrayList<Contestant> contestantsListTest = new ArrayList<Contestant>();
    ArrayList<Contestant> contestantsList = new ArrayList<Contestant>();

    @org.junit.Before
    public void setContestant() {
        Contestant contestant = new Contestant("John Smith", 12.61, 500.0, 9.22, 150, 60.39, 16.43,
                21.60, 260, 35.81, 325.72);
        Contestant contestant1 = new Contestant("Jane Doe", 13.04, 453.0, 7.79, 155, 64.72, 18.74,
                24.20, 240, 28.20, 410.76);
        Contestant contestant2 = new Contestant("Jaan Lepp", 13.75, 484.0, 10.12, 150, 68.44, 19.18,
                30.85, 280, 33.88, 382.75);
        Contestant contestant3 = new Contestant("Foo Bar", 13.43, 435.0, 8.64, 150, 66.06, 19.05,
                24.89, 220, 33.48, 411.01);
        contestantsListTest.add(contestant);
        contestantsListTest.add(contestant1);
        contestantsListTest.add(contestant2);
        contestantsListTest.add(contestant3);

    }
    @Test
    public void readFile() throws Exception {
        contestantsList = reader.readFile("src/test/resources/test_results.csv");
        for( int i = 0; i < contestantsListTest.size(); i++) {
            assertEquals(contestantsListTest.get(i).getName(), contestantsList.get(i).getName());
            assertEquals(contestantsListTest.get(i).getLongJump(), contestantsList.get(i).getLongJump(), 1);
            assertEquals(contestantsListTest.get(i).getLongRun(), contestantsList.get(i).getLongRun(), 0);
            assertEquals(contestantsListTest.get(i).getDiscusThrow(), contestantsList.get(i).getDiscusThrow(), 0);
            assertEquals(contestantsListTest.get(i).getHurdlesRun(), contestantsList.get(i).getHurdlesRun(), 0);
            assertEquals(contestantsListTest.get(i).getHundredRun(), contestantsList.get(i).getHundredRun(), 0);
            assertEquals(contestantsListTest.get(i).getFourHundredRun(), contestantsList.get(i).getFourHundredRun(), 0);
            assertEquals(contestantsListTest.get(i).getJavelinThrow(), contestantsList.get(i).getJavelinThrow(), 0);
            assertEquals(contestantsListTest.get(i).getPoleVault(), contestantsList.get(i).getPoleVault(), 0);
            assertEquals(contestantsListTest.get(i).getShotPut(), contestantsList.get(i).getShotPut(), 0);
            assertEquals(contestantsListTest.get(i).getHighJump(), contestantsList.get(i).getHighJump(), 0);
        }

    }
    @Test
    public void readFileWrong(){
        try {
            reader.readFile("src/test/resources/wrong_test_results.csv");
        } catch (Exception e) {
            assertTrue(e instanceof NumberFormatException);
        }
    }
    @Test
    public void readFileShort() {
        try {
            reader.readFile("src/test/resources/short_test_results.csv");
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
            assertTrue(e.getMessage().equals("Line 2 of source .csv does not contain all neccessary arguments. Check file!"));
        }
    }
    @Test
    public void readFileNotFound() {
        try {
            reader.readFile("src/tes/short_test_results.csv");
        } catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
    }
}