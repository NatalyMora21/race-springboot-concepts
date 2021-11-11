package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceQueryController {

    private final RaceRepository repository;

    public RaceQueryController(RaceRepository raceRepository){
        this.repository = raceRepository;
    }

    @GetMapping("/race/{id}")
    public Race getGame(@PathVariable("id") String id){
        return repository.findById(id);
    }
}
