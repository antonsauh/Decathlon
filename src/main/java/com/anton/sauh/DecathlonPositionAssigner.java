package com.anton.sauh;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by AntonSauh
 */

public class DecathlonPositionAssigner implements IPositionAssigner {


    public void assignPositions(ArrayList<Contestant> contestantsList) {
        sortResults(contestantsList);

        int totalNumberOfContestants = contestantsList.size();
        int indexOfFirstDuplicateScoreElement = 0;
        boolean duplicateScoreIsPresent = false;

        for (int index = 0; index < totalNumberOfContestants; index++) {
            if (index + 1 == totalNumberOfContestants) {
                if (!duplicateScoreIsPresent) {
                    contestantsList.get(index).setPosition(Integer.toString(totalNumberOfContestants - index));
                } else {
                    assignPositionsForDuplicateScores(indexOfFirstDuplicateScoreElement, index, contestantsList,
                            totalNumberOfContestants);
                }
            } else if (contestantsScoresEqual(contestantsList, index)) {
                if (!duplicateScoreIsPresent) {
                    indexOfFirstDuplicateScoreElement = index;
                    duplicateScoreIsPresent = true;
                }
            } else if (!contestantsScoresEqual(contestantsList, index)) {

                if (!duplicateScoreIsPresent) {
                    int contestantPosition = totalNumberOfContestants - index;
                    contestantsList.get(index).setPosition(Integer.toString(contestantPosition));
                    duplicateScoreIsPresent = false;


                } else {
                    assignPositionsForDuplicateScores(indexOfFirstDuplicateScoreElement, index, contestantsList,
                            totalNumberOfContestants);
                    indexOfFirstDuplicateScoreElement = 0;
                    duplicateScoreIsPresent = false;
                }
            }
        }
    }
    private void assignPositionsForDuplicateScores(int indexStartDuplicate, int indexOfIteration,
                                                   ArrayList<Contestant> contestantsList, int totalNumberOfContestants){
        int startingContestantPosition = totalNumberOfContestants - indexOfIteration;
        int endingContestantPosition = totalNumberOfContestants - indexStartDuplicate;
        for(int i = indexStartDuplicate; i <= indexOfIteration; i++) {
            contestantsList.get(i).setPosition(Integer.toString(startingContestantPosition) + "-" +
                    Integer.toString(endingContestantPosition));
        }

    }
    private boolean contestantsScoresEqual (ArrayList<Contestant> contestantsList, int index) {

        int nextArrayElementIndex = index + 1;
        return contestantsList.get(index).getScore() == contestantsList.get(nextArrayElementIndex).getScore();
    }


    private ArrayList<Contestant> sortResults(ArrayList<Contestant> Contestants) {
        Contestants.sort(Comparator.comparingInt(Contestant::getScore));
        return Contestants;
    }
}
