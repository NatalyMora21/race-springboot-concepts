package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Race;

public interface RaceRepository {
    Race findById (String id);
}
