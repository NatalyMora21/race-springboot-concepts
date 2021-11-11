package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.commands.StartGameCommand;
import org.springframework.stereotype.Component;

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
        if(race.podium().size() >= 3){
            System.out.println("Podium already full");
            return race;
        }
        if(race.state() == false){
            race.startGame();
        }
        race.moveRandomUser();

        return race;
    }
}
