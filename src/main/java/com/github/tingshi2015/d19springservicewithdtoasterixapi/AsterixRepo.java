package com.github.tingshi2015.d19springservicewithdtoasterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsterixRepo extends MongoRepository<Character, String>{
}
