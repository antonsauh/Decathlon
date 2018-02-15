package com.anton.sauh;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;

public interface IWriter {
    void writeToConsole(ArrayList<Contestant> contestantsList);
}
