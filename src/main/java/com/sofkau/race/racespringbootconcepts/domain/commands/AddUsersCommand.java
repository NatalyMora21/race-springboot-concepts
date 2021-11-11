package com.sofkau.race.racespringbootconcepts.domain.commands;

import java.io.Serializable;

public class AddUsersCommand implements Serializable {
    private String raceId;
    private String userName;
    private Integer numberOfWins;
    private Integer lane;
    private String carBrand;

    public AddUsersCommand() {
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(Integer numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public Integer getLane() {
        return lane;
    }

    public void setLane(Integer lane) {
        this.lane = lane;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}
