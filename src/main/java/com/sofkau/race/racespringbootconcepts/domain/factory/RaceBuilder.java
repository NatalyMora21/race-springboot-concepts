package com.sofkau.race.racespringbootconcepts.domain.factory;

import com.sofkau.race.racespringbootconcepts.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceBuilder {
    private String title;
    private Map<String, User> users;
    private Integer trackDistance;
    //String represents UserID
    private List<String> podium;
    private boolean state;
    private Integer numberOfPlayers;

    public RaceBuilder(){
        this.users = new HashMap<>();
        this.podium = new ArrayList<>();
        this.state = false;
    }

    public RaceBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public RaceBuilder withTrackDistance(Integer trackDistance){
        this.trackDistance = trackDistance;
        return this;
    }

    public RaceBuilder withPodium(List<String> podium){
        this.podium = podium;
        return this;
    }

    public RaceBuilder withState(boolean state){
        this.state = state;
        return this;
    }

    public RaceBuilder withNumberOfPlayers(Integer numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        return this;
    }

    public RaceBuilder withUser(User user){
        users.put(user.id(), user);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Integer getTrackDistance() {
        return trackDistance;
    }

    public List<String> getPodium() {
        return podium;
    }

    public boolean isState() {
        return state;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
