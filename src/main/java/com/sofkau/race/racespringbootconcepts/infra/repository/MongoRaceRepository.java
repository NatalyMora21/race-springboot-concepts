package com.sofkau.race.racespringbootconcepts.infra.repository;

import com.sofkau.race.racespringbootconcepts.domain.Race;
import com.sofkau.race.racespringbootconcepts.domain.User;
import com.sofkau.race.racespringbootconcepts.domain.factory.RaceBuilder;
import com.sofkau.race.racespringbootconcepts.domain.usecase.RaceRepository;
import com.sofkau.race.racespringbootconcepts.infra.documents.RaceDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class MongoRaceRepository implements RaceRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Race findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        var document = mongoTemplate.findOne(query, RaceDocument.class, "race");
        var builder = new RaceBuilder();
        Optional.ofNullable(document).ifPresent((doc)->{
            builder.withTitle(doc.getTitle());
            builder.withTrackDistance(doc.getTrackDistance());
            builder.withState(doc.isState());
            builder.withPodium(doc.getPodium());
            builder.withNumberOfPlayers(doc.getNumberOfPlayers());
            doc.getUsers().forEach((key, userDocument)->{
                builder.withUser(User.from(key,
                        userDocument.getUserName(),
                        userDocument.getNumberOfWins(),
                        userDocument.getLane(),
                        userDocument.getCarBrand()));
            });
        });
        return Race.from(id, builder);
    }

    @Override
    public Race save(Race race) {
        var raceDocument = new RaceDocument();
        raceDocument.setId(race.id());
        raceDocument.setTitle(race.title());
        raceDocument.setPodium(race.podium());
        raceDocument.setNumberOfPlayers(race.numberOfPlayers());
        raceDocument.setTrackDistance(race.trackDistance());
        raceDocument.setState(race.state());
        race.users().forEach((key, user)->{
            raceDocument.withUser(user);
        });
        mongoTemplate.save(raceDocument, "race");
        return race;
    }
}
