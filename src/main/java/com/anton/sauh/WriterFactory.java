package com.anton.sauh;

/**
 * Created by AntonSauh
 */
public class WriterFactory {
    public IWriter getWriter(String outputType) {

        if (outputType.equals("xml")) {
            return new XmlWriter();
        } else {
            System.out.println("Unkown output type: " + outputType + "\n" +
                    "Known types are: xml\n" +
                    "Please pass correct output type!");
            return null;
        }
    }
}
