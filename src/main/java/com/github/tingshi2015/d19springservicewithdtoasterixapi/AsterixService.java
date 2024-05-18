package com.github.tingshi2015.d19springservicewithdtoasterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsterixService {
    private final AsterixRepo asterixRepo;
    private final IdService idService;

    public List<Character> getAll() {
        return asterixRepo.findAll();
    }

    public Character getCharacterById(String id) {
        return asterixRepo.findById(id)
                .orElseThrow();
    }

//POST with DTO, return with id
/*    public Character createCharacter(CharacterDTO characterDTO) {
        Character character = new Character(UUID.randomUUID().toString(),characterDTO.name(), characterDTO.age(), characterDTO.profession());
        return asterixRepo.save(character);
    }*/

//POST with DTO, return also DTO
    public CharacterDTO createCharacter(CharacterDTO characterDTO) {
        //Character characterToDB = new Character(UUID.randomUUID().toString(),characterDTO.name(), characterDTO.age(), characterDTO.profession());
        Character characterToDB = new Character(idService.randomId(), characterDTO.name(), characterDTO.age(), characterDTO.profession());
        Character characterFromDB = asterixRepo.save(characterToDB);
        CharacterDTO characterToController = new CharacterDTO(characterFromDB.name(), characterFromDB.age(), characterDTO.profession());
        return characterToController;
    }

    public CharacterDTO updateCharacterById(CharacterDTO characterDTO, String id) {
        if (asterixRepo.existsById(id)){
            Character characterToDB = new Character(id,characterDTO.name(),characterDTO.age(), characterDTO.profession());
            Character characterFromDB = asterixRepo.save(characterToDB);
            return new CharacterDTO(characterFromDB.name(),characterFromDB.age(), characterFromDB.profession());
        }
        else {throw new NoSuchElementException("This can't update! This id: " + id + "doesn't exist!");}
    }

    public void deleteCharacterById(String id) {
        if (asterixRepo.existsById(id)) {
            asterixRepo.deleteById(id);
        } else {
            throw new NoSuchElementException("This id:" + id + " doesn't exist!");
        }
    }
}
