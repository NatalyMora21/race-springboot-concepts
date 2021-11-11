package com.sofkau.race.racespringbootconcepts.domain;

public class User {
    private String id;
    private String avatar;
    private String userName;
    private Integer progress;
    private Integer NumberOfWins;
    private Integer lane;
    private String carBrand;

    public User(String id, String userName, Integer numberOfWins, Integer lane, String carBrand, int progress, String avatar) {
        this.id = id;
        this.userName = userName;
        this.progress = progress;
        this.NumberOfWins = numberOfWins;
        this.lane = lane;
        this.carBrand = carBrand;
        this.avatar = avatar;
    }

    public static User from(String id, String userName, Integer numberOfWins, Integer lane, String carBrand, Integer progress, String avatar){
        return new User(id, userName, numberOfWins, lane, carBrand, progress, avatar);
    }

    public void updateProgress(int newProgress){
        this.progress = this.progress + newProgress;
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

    public String avatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userName='" + userName + '\'' +
                ", progress=" + progress +
                ", NumberOfWins=" + NumberOfWins +
                ", lane=" + lane +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }
}
