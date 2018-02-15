package com.anton.sauh;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader implements IReader {

    // Constants
    public static final int centimetersInMeter = 100;
    public static final int precisionPoint = 2;

    public ArrayList<Contestant> readFile(String path) throws Exception {

        BufferedReader br = null;
        String line = "";
        String splitBy = ";";
        ArrayList<Contestant> contestantsList = new ArrayList<Contestant>();
        int lineNumber = 1;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] contestantData = line.split(splitBy);
                if(contestantData.length == 11) {
                    Contestant contestant = new Contestant(contestantData[0],
                            CheckTime(contestantData[1], false),
                            MetresToCmeters(Double.parseDouble(contestantData[2])),
                            Double.parseDouble(contestantData[3]),
                            MetresToCmeters(Double.parseDouble(contestantData[4])),
                            CheckTime(contestantData[5], false),
                            CheckTime(contestantData[6], false),
                            Double.parseDouble(contestantData[7]),
                            MetresToCmeters(Double.parseDouble(contestantData[8])),
                            Double.parseDouble(contestantData[9]),
                            CheckTime(contestantData[10], true));
                    contestantsList.add(contestant);
                    lineNumber++;
                } else {
                    contestantsList.clear();
                    throw new Exception("Line " + lineNumber +" of source .csv does not contain all" +
                            " neccessary arguments. Check file!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw (e);
        } catch(Exception e){
            e.printStackTrace();
            throw(e);
                } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contestantsList;
    }

        private double MetresToCmeters(double meters) {
        return RoundResult(meters * centimetersInMeter, precisionPoint);
    }

    private double RoundResult(double result, int precise) {

        precise = 10^precise;
        result = result *precise;
        int i = (int) Math.round(result);
        return (double) i/precise;

    }

    private double CheckTime(String time, boolean last) {
            String[] stringArray = time.split("\\.");
            if (stringArray.length == 3 && last) {
                double minutes = Double.parseDouble(stringArray[0]);
                minutes = minutes * 60;
                double seconds = Double.parseDouble(stringArray[1] + "." + stringArray[2]);
                return minutes + seconds;
            } else {
                return Double.parseDouble(time);
            }
    }
}
