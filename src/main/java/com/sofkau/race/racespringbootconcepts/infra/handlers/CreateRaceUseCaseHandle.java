package com.sofkau.race.racespringbootconcepts.infra.handlers;


import com.sofkau.race.racespringbootconcepts.domain.commands.CreateRaceCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.CreateRaceUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateRaceUseCaseHandle {

    private CreateRaceUseCase createRaceUseCase;

    public CreateRaceUseCaseHandle(CreateRaceUseCase createRaceUseCase) {
        this.createRaceUseCase = createRaceUseCase;
    }

    @EventListener
    public void handle(CreateRaceCommand createRaceCommand){
        var race = createRaceUseCase.apply(createRaceCommand);
        System.out.println("printing from create race handle");
        System.out.println(race.id());
    }
}
