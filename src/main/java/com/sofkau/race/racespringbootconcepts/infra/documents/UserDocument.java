package com.sofkau.race.racespringbootconcepts.infra.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDocument {

    @Id
    private String id;
    private String userName;
    private Integer progress;
    private Integer NumberOfWins;
    private Integer lane;
    private String carBrand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getNumberOfWins() {
        return NumberOfWins;
    }

    public void setNumberOfWins(Integer numberOfWins) {
        NumberOfWins = numberOfWins;
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
