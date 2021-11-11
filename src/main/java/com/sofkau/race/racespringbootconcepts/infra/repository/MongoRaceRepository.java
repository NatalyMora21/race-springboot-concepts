package com.sofkau.race.racespringbootconcepts.infra.repository;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import com.sofkau.race.racespringbootconcepts.infra.documents.RaceDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class MongoRaceRepository implements RaceRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Race findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        var document = mongoTemplate.findOne(query, RaceDocument.class, "race");
        return race;
    }

    @Override
    public Race save(Race race) {
        return mongoTemplate.save(race, "race");
    }
}
