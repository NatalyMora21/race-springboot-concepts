package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.commands.CreateRaceCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateRaceUseCase implements Function<CreateRaceCommand, Race> {

    private final RaceRepository repository;

    public CreateRaceUseCase(RaceRepository repository){
        this.repository = repository;
    }

    @Override
    public Race apply(CreateRaceCommand command) {
        var race = new Race(UUID.randomUUID().toString(),
                command.getTitle(),
                command.getTrackDistance() * 10,
                command.getNumberOfPlayers());
        return repository.save(race);
    }
}
