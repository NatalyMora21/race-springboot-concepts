package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import com.sofkau.race.racespringbootconcepts.infra.documents.RaceDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceQueryController {

    private final MongoTemplate repository;

    public RaceQueryController(MongoTemplate template){
        this.repository = template;
    }

    @GetMapping("/race/{id}")
    public RaceDocument getGame(@PathVariable("id") String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return repository.findOne(query, RaceDocument.class, "race");
    }
}
