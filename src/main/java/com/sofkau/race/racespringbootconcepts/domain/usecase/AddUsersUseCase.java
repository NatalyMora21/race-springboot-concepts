package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class AddUsersUseCase implements Function<AddUsersCommand, Race> {

    private RaceRepository repository;

    public AddUsersUseCase(RaceRepository repository){
        this.repository = repository;
    }

    @Override
    public Race apply(AddUsersCommand command) {
        var race = repository.findById(command.getRaceId());
        race.addUser(UUID.randomUUID().toString(),
                command.getUserName(),
                command.getNumberOfWins(),
                command.getLane(),
                command.getCarBrand());
        return race;
    }
}
