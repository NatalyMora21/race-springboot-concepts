package com.sofkau.race.racespringbootconcepts.infra.handlers;


import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.AddUsersUseCase;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


@Component
public class AddUserUseCaseHandle {

    private final AddUsersUseCase addUsersUseCase;
    private final RaceRepository repository;

    public AddUserUseCaseHandle(AddUsersUseCase addUsersUseCase, RaceRepository repository) {
        this.addUsersUseCase = addUsersUseCase;
        this.repository = repository;
    }

    @EventListener
    public void handle(AddUsersCommand addUsersCommand){
        var race = this.addUsersUseCase.apply(addUsersCommand);
        this.repository.save(race);
    }
}
