package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import com.sofkau.race.racespringbootconcepts.domain.commands.CreateRaceCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.CreateRaceUseCase;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceCommandController {

    private final ApplicationEventPublisher eventPublicher;

    public RaceCommandController( ApplicationEventPublisher publisher){
        this.eventPublicher = publisher;
    }

    //No tiene respuesta del back para que el front tenga el id del agregado
    //tiene que hacerse por medio de un socket
    @PostMapping("/createRace")
    public void create(@RequestBody CreateRaceCommand command){
        this.eventPublicher.publishEvent(command);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody AddUsersCommand command){
        this.eventPublicher.publishEvent(command);
    }
}
