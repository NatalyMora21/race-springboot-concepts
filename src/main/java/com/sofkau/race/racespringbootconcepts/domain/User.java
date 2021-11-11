package com.sofkau.race.racespringbootconcepts.domain;

public class User {
    private String id;
    private String userName;
    private Integer progress;
    private Integer NumberOfWins;
    private Integer lane;
    private String carBrand;

    public User(String id, String userName, Integer numberOfWins, Integer lane, String carBrand) {
        this.id = id;
        this.userName = userName;
        this.progress = 0;
        NumberOfWins = numberOfWins;
        this.lane = lane;
        this.carBrand = carBrand;
    }

    public String id() {
        return id;
    }

    public String userName() {
        return userName;
    }

    public Integer progress() {
        return progress;
    }

    public Integer numberOfWins() {
        return NumberOfWins;
    }

    public Integer lane() {
        return lane;
    }

    public String carBrand() {
        return carBrand;
    }
}
