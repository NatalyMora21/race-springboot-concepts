package com.sofkau.race.racespringbootconcepts.infra.repository;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
public class MongoRaceRepository implements RaceRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Race findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.findOne(query, Race.class, "race");
        return null;
    }
}
