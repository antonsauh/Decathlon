package com.anton.sauh;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;

public class XmlWriter implements IWriter {


    @Override
    public void writeToConsole(ArrayList<Contestant> contestantsList) {
        try {
        JAXBContext jaxbContext = JAXBContext.newInstance(Contestants.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(new Contestants(contestantsList), System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
