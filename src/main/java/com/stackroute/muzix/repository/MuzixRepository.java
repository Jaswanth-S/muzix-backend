package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MuzixRepository extends MongoRepository<Track, String> {

}
