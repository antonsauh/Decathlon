package com.anton.sauh;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contestant")
@XmlAccessorType (XmlAccessType.FIELD)

public class Contestant implements IContestant {
    private double hundredRun;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double fourHundredRun;
    private double hurdlesRun;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private double longRun;
    private String name;
    private int score;
    private String position;

    //constructor for XML reader
    public Contestant(){
    }

    public Contestant(String name, double hundredRun, double longJump, double shotPut, double highJump, double fourHundredRun,
                      double hurdlesRun, double discusThrow, double poleVault, double javelinThrow, double longRun) {
        this.name = name;
        this.hundredRun = hundredRun;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.fourHundredRun = fourHundredRun;
        this.hurdlesRun = hurdlesRun;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.longRun = longRun;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getLongJump() {
        return longJump;
    }

    public double getShotPut() {
        return shotPut;
    }

    public double getHighJump() {
        return highJump;
    }

    public double getFourHundredRun() {
        return fourHundredRun;
    }

    public double getHurdlesRun() {
        return hurdlesRun;
    }

    public double getDiscusThrow() {
        return discusThrow;
    }

    public double getPoleVault() {
        return poleVault;
    }

    public double getJavelinThrow() {
        return javelinThrow;
    }

    public double getLongRun() {
        return longRun;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHundredRun() {
        return hundredRun;
    }

    public String getName() {
        return name;
    }


}
