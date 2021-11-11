package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.User;
import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import com.sofkau.race.racespringbootconcepts.domain.commands.StartGameCommand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class StartGameUseCase implements Function<StartGameCommand, Race> {

    private RaceRepository repository;

    public StartGameUseCase(RaceRepository repository){
        this.repository = repository;
    }

    @Override
    public Race apply(StartGameCommand command) {
        var race = repository.findById(command.getRaceId());
        if(race.users().size() < 3){
            System.out.println("Insufficient amount of players");
            return race;
        }
        var playing = true;
        if(race.state() == false){
            race.startGame();
        }
        race.moveRandomUser();

        if(race.podium().size() >= 3){
            playing = false;
        }

        return race;
    }
}
