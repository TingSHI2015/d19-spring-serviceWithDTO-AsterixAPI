package com.github.tingshi2015.d19springservicewithdtoasterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsterixRepo extends MongoRepository<Character, String>{

//----wrong! queryAllByAge can only return non-DTO type!!!!
    //List<CharacterDTO> queryAllByAge(int age);

    List<Character> queryAllByAge(int age);
}
