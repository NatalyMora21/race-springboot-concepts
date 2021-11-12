package com.sofkau.race.racespringbootconcepts.domain.dto;

import java.io.Serializable;
import java.util.List;

public class CreateRaceWithUsersDto implements Serializable {
    private String title;
    private String trackDistance;
    private List<UserDto> users;

    public CreateRaceWithUsersDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(String trackDistance) {
        this.trackDistance = trackDistance;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
