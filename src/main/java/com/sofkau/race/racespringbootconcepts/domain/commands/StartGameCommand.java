package com.sofkau.race.racespringbootconcepts.domain.commands;

import java.io.Serializable;

public class StartGameCommand implements Serializable {
    private String raceId;

    public StartGameCommand() {
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }
}
