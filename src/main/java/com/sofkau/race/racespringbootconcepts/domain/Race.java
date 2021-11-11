package com.sofkau.race.racespringbootconcepts.domain;

import com.sofkau.race.racespringbootconcepts.domain.factory.RaceBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private String id;
    private String title;
    private Map<String, User> users;
    private Integer trackDistance;
    //String represents UserID
    private List<String> podium;
    private boolean state;
    private Integer numberOfPlayers;

    public Race(String id, String title, Integer trackDistance, Integer numberOfPlayers) {
        this.id = id;
        this.title = title;
        this.users = new HashMap<>();
        this.trackDistance = trackDistance;
        this.podium = new ArrayList<>();
        this.state = false;
        this.numberOfPlayers = numberOfPlayers;
    }

    private Race(String id){
        this.id = id;
        this.users = new HashMap<>();
        this.podium = new ArrayList<>();
        this.state = false;
    }

    public static Race from(String id, RaceBuilder raceBuilder){
        var race = new Race(id);
        race.title = raceBuilder.getTitle();
        race.users = raceBuilder.getUsers();
        race.trackDistance = raceBuilder.getTrackDistance();
        race.podium = raceBuilder.getPodium();
        race.state = raceBuilder.isState();
        race.numberOfPlayers = raceBuilder.getNumberOfPlayers();
        return race;
    }

    public void addUser(String id, String userName, Integer numberOfWins, Integer lane, String carBrand){
        var user = new User(id, userName, numberOfWins, lane, carBrand);
        this.users.put(id, user);
    }

    public void startGame(){
        this.state = true;
    }

    public void stopGame(){
        this.state = false;
    }

    public void addWinner(String userId){
        this.podium.add(userId);
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public Map<String, User> users() {
        return users;
    }

    public Integer trackDistance() {
        return trackDistance;
    }

    public List<String> podium() {
        return podium;
    }

    public boolean state() {
        return state;
    }

    public Integer numberOfPlayers() {
        return numberOfPlayers;
    }
}
