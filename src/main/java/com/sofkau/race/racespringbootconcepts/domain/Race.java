package com.sofkau.race.racespringbootconcepts.domain;

import com.sofkau.race.racespringbootconcepts.domain.commands.MessageToClient;
import com.sofkau.race.racespringbootconcepts.domain.factory.RaceBuilder;
import com.sofkau.race.racespringbootconcepts.infra.entrypoints.SocketController;

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

    public void addUser(String id, String userName, Integer numberOfWins, Integer lane, String carBrand, int progress, String avatar){
        var user = new User(id, userName, numberOfWins, lane, carBrand, progress, avatar);
        this.users.put(id, user);
    }

    public void moveRandomUser(){
        List<String> userIterator = new ArrayList<>();
        this.users.forEach((key, user)->{
            userIterator.add(key);
        });
        var playing = true;
        SocketController socket = new SocketController();
        while(playing){
            int newProgress = (int)Math.floor(Math.random() * 6 + 1);
            int userToAdvance = (int)Math.floor(Math.random() * userIterator.size());
            System.out.println("progress: " + newProgress);
            System.out.println("index of list " + userToAdvance);
            String key = userIterator.get(userToAdvance);
            User user = this.users.get(key);
            System.out.println("User Progress: " + user.progress());
            user.updateProgress(newProgress);
            if(user.progress() >= this.trackDistance){
                this.podium.add(user.id());
                userIterator.remove(userToAdvance);
            }
            if(this.podium.size() >= 3){
                playing = false;
                this.stopGame();
            }
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println(e.toString());
            }
            users.put(key, user);
            //socket.send(this.id, new MessageToClient("e73dd538-ab21-401b-aa03-db40d1ae45a9", "Update from backend", this));
            System.out.println("Esto es this en race: " + this);
        }

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

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", users=" + users +
                ", trackDistance=" + trackDistance +
                ", podium=" + podium +
                ", state=" + state +
                ", numberOfPlayers=" + numberOfPlayers +
                '}';
    }
}
