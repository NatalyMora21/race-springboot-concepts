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
        System.out.println(race);
        race.moveRandomUser();
        //Solo se hace una vez
        race.startGame();
        return race;
    }
}
