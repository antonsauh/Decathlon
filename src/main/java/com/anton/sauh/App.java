package com.anton.sauh;


import java.util.ArrayList;

public class App {

    public static final int numberOfCliArguments = 2;
    public static final int indexOfFilePath = 0;
    public static final int indexOfOutputType = 1;

    public static void main(String[] args) {

        if(args.length == numberOfCliArguments) {

            String filePath = args[indexOfFilePath];
            String outputType =  args[indexOfOutputType];

            ReaderFactory readerFactory = new ReaderFactory();
            WriterFactory writerFactory = new WriterFactory();

            DecathlonPositionAssigner positionAssigner = new DecathlonPositionAssigner();
            DecathlonResultCalculator resultCalculator = new DecathlonResultCalculator();

            try {
                ArrayList<Contestant> contestantList;
                IReader reader = readerFactory.getReader(filePath);
                IWriter writer = writerFactory.getWriter(outputType);

                contestantList = reader.readFile(filePath);

                resultCalculator.calculateScores(contestantList);

                positionAssigner.assignPositions(contestantList);

                writer.writeToConsole(contestantList);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
           System.out.println("No arguments passed \n \n" +
                   "Please pass path to source file as the first argument\n" +
                   "and output format as the second argument separated with whitespace\n \n" +
                   "Example: files/data.csv xml");
        }
    }
}
