package com.anton.sauh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.Exchanger;


public class DecathlonResultCalculator implements IResultCalculator {

    private final double[] hundredRunABC = new double[]{25.4347,18.0, 1.81};
    private final double[] longJumpABC = new double[]{0.14354, 220.0, 1.4};
    private final double[] shotPutABC = new double[]{51.39, 1.5, 1.05};
    private final double[] highJumpABC = new double[]{0.8465,75.0 , 1.42};
    private final double[] fourHundredRunABC = new double[]{1.53775, 82.0, 1.81};
    private final double[] hurdlesRunABC = new double[]{5.74352, 28.5, 1.92};
    private final double[] discusThrowABC = new double[]{12.91, 4, 1.1};
    private final double[] poleVaultABC = new double[]{0.2797, 100.0, 1.35};
    private final double[] javelinThrowABC = new double[]{10.14, 7, 1.08};
    private final double[] longRunABC = new double[]{0.03768, 480.0, 1.85};


    public void calculateScores(ArrayList<Contestant> Contestants) {

        DecathlonTrackEventScoreCalculator calculateTrackEvent = new DecathlonTrackEventScoreCalculator();
        DecathlonFieldEventScoreCalculator calculateFieldEvent = new DecathlonFieldEventScoreCalculator();

        Contestants.forEach(contestant -> {
            try {
                int score;
                double hundredRun = contestant.getHundredRun();
                double longJump = contestant.getLongJump();
                double shotPut = contestant.getShotPut();
                double highJump = contestant.getHighJump();
                double fourHundredRun = contestant.getFourHundredRun();
                double hurdlesRun = contestant.getHurdlesRun();
                double discusThrow = contestant.getDiscusThrow();
                double poleVault = contestant.getPoleVault();
                double javelinThrow = contestant.getJavelinThrow();
                double longRun = contestant.getLongRun();

                score = calculateTrackEvent.calculateScoreForEvent(hundredRun, hundredRunABC) +
                        calculateTrackEvent.calculateScoreForEvent(fourHundredRun, fourHundredRunABC) +
                        calculateTrackEvent.calculateScoreForEvent(hurdlesRun, hurdlesRunABC) +
                        calculateTrackEvent.calculateScoreForEvent(longRun, longRunABC) +
                        calculateFieldEvent.calculateScoreForEvent(longJump, longJumpABC) +
                        calculateFieldEvent.calculateScoreForEvent(shotPut, shotPutABC) +
                        calculateFieldEvent.calculateScoreForEvent(highJump, highJumpABC) +
                        calculateFieldEvent.calculateScoreForEvent(discusThrow, discusThrowABC) +
                        calculateFieldEvent.calculateScoreForEvent(poleVault, poleVaultABC) +
                        calculateFieldEvent.calculateScoreForEvent(javelinThrow, javelinThrowABC);
                contestant.setScore(score);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Data in file is invalid");
                throw e;
            }
        });

    }

}
