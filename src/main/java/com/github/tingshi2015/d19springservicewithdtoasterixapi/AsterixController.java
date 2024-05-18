package com.github.tingshi2015.d19springservicewithdtoasterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
@RequiredArgsConstructor
public class AsterixController {
    private final AsterixService asterixService;

    @GetMapping("/characters")
    public List<Character> getAllCharacters(){
        return asterixService.getAll();
    }

    @GetMapping("/characters/{id}")
    public Character getCharacterById(@PathVariable String id){
        return asterixService.getCharacterById(id);
    }

//Post without DTO
/*    @PostMapping("/characters")
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestBody Character character){
        return asterixService.createCharacter(character);
    }*/

//POST with DTO, return(i.e. ResponseBody) with id
/*    @PostMapping("/characters")
    public Character createCharacter(@RequestBody CharacterDTO characterDTO){
        return asterixService.createCharacter(characterDTO);
    }*/

//POST with DTO, return(i.e. ResponseBody) also with DTO!
    @PostMapping("/characters")
    public CharacterDTO createCharacter(@RequestBody CharacterDTO characterDTO){
        return asterixService.createCharacter(characterDTO);
    }



    @PutMapping("/characters/{id}")
    public CharacterDTO updateCharacterById(@RequestBody CharacterDTO characterDTO, @PathVariable String id){
        return asterixService.updateCharacterById(characterDTO,id);
    }

    @DeleteMapping("/characters/{id}")
    public void deleteCharacterById(@PathVariable String id){      //ResponseBody for DELETE is empty!
        asterixService.deleteCharacterById(id);
    }


}
