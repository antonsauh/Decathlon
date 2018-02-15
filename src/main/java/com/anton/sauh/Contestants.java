package com.anton.sauh;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by AntonSauh
 */

@XmlRootElement(name = "contestants")
@XmlAccessorType (XmlAccessType.FIELD)

public class Contestants {
    @XmlElement(name = "contestant")
    private ArrayList<Contestant> contestantsList;

    Contestants(ArrayList<Contestant> contestantsList) {
        this.contestantsList = contestantsList;
    }
    //no args constructor for JAXB
    Contestants() {

    }
}
