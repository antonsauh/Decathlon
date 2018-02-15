package com.anton.sauh;

import java.util.concurrent.ExecutionException;

/**
 * Created by AntonSauh
 */
public class ReaderFactory {

    public IReader getReader(String filePath) throws Exception {
        int fileTypeIndexInArray = 1;
        String fileType;
        try {
            fileType = filePath.split("\\.")[fileTypeIndexInArray];
            if(fileType.equals("csv") ) {
                return new CsvReader();
            } else {
                throw new Exception("Unknown file type: " + fileType);
            }
        } catch( ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Incorrect arguments was passed as file path. \n" +
                    "Please pass file path in such format: app/src/myFile.csv");
            return null;
        } catch (Exception e){
            e.printStackTrace();
            throw(e);
        }
    }
}
