package com.sofkau.race.racespringbootconcepts.infra.handlers;

import com.sofkau.race.racespringbootconcepts.domain.commands.StartGameCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import com.sofkau.race.racespringbootconcepts.domain.usecase.StartGameUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartGameUseCaseHandle {

    private final StartGameUseCase startGameUseCase;
    private final RaceRepository repository;

    public StartGameUseCaseHandle(StartGameUseCase startGameUseCase, RaceRepository repository) {
        this.startGameUseCase = startGameUseCase;
        this.repository = repository;
    }

    @EventListener
    public void handle(StartGameCommand command){

        //While true
        var playing = true;
        while(playing){
            var race = this.startGameUseCase.apply(command);
            if(race.podium().size() >= 3){
                playing = false;
            }
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println(e.toString());
            }
        }
    }
}
