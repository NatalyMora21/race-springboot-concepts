package com.sofkau.race.racespringbootconcepts.infra.documents;

import com.sofkau.race.racespringbootconcepts.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;


@Document
public class RaceDocument {

    @Id
    private String id;
    private String title;
    private Map<String, UserDocument> users;
    private Integer trackDistance;
    //String represents UserID
    private List<String> podium;
    private boolean state;
    private Integer numberOfPlayers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, UserDocument> getUsers() {
        return users;
    }

    public void setUsers(Map<String, UserDocument> users) {
        this.users = users;
    }

    public Integer getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(Integer trackDistance) {
        this.trackDistance = trackDistance;
    }

    public List<String> getPodium() {
        return podium;
    }

    public void setPodium(List<String> podium) {
        this.podium = podium;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
