package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import com.sofkau.race.racespringbootconcepts.domain.commands.CreateRaceCommand;
import com.sofkau.race.racespringbootconcepts.domain.commands.StartGameCommand;
import com.sofkau.race.racespringbootconcepts.domain.dto.CreateRaceWithUsersDto;
import com.sofkau.race.racespringbootconcepts.domain.usecase.CreateRaceUseCase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceCommandController {

    private final ApplicationEventPublisher eventPublisher;
    private final CreateRaceUseCase createRaceUseCase;

    public RaceCommandController( ApplicationEventPublisher publisher, CreateRaceUseCase createRaceUseCase){
        this.eventPublisher = publisher;
        this.createRaceUseCase = createRaceUseCase;
    }

    //No tiene respuesta del back para que el front tenga el id del agregado
    //tiene que hacerse por medio de un socket
    @PostMapping("/createRace")
    public void create(@RequestBody CreateRaceCommand command){
        this.eventPublisher.publishEvent(command);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody AddUsersCommand command){
        this.eventPublisher.publishEvent(command);
    }

    @PostMapping("/createRaceWithUsers")
    public String createRaceWIthUsers(@RequestBody CreateRaceWithUsersDto createRaceWithUsersDto){
        CreateRaceCommand createRaceCommand = new CreateRaceCommand();
        AddUsersCommand addUsersCommand = new AddUsersCommand();
        createRaceCommand.setTitle(createRaceWithUsersDto.getTitle());
        createRaceCommand.setTrackDistance(Integer.parseInt(createRaceWithUsersDto.getTrackDistance()));
        createRaceCommand.setNumberOfPlayers(createRaceWithUsersDto.getUsers().size());
        var race = createRaceUseCase.apply(createRaceCommand);
        return race.id();
    }

    @PostMapping("/startGame")
    public void startGame(@RequestBody StartGameCommand command){
        this.eventPublisher.publishEvent(command);
    }
}
