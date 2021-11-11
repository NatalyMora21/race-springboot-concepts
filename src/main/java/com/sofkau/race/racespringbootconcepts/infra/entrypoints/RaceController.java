package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.domain.commands.CreateRaceCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.CreateRaceUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceController {

    private CreateRaceUseCase createRaceUseCase;

    public RaceController(CreateRaceUseCase createRaceUseCase){
        this.createRaceUseCase = createRaceUseCase;
    }

    @PostMapping("/createRace")
    public String create(@RequestBody CreateRaceCommand command){
        var race = createRaceUseCase.apply(command);
        return race.title();
    }
}
