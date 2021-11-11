package com.sofkau.race.racespringbootconcepts.domain.commands;

import com.sofkau.race.racespringbootconcepts.domain.User;

import java.io.Serializable;

public class CreateRaceCommand implements Serializable {
    private String title;
    private Integer trackDistance;
    private Integer numberOfPlayers;

    public CreateRaceCommand() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(Integer trackDistance) {
        this.trackDistance = trackDistance;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
