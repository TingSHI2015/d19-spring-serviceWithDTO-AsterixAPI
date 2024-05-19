package com.github.tingshi2015.d19springservicewithdtoasterixapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {
    private final AsterixRepo mockRepo = mock(AsterixRepo.class);

    @Test
    void getAll() {
        //GIVEN
        AsterixService asterixService = new AsterixService(mockRepo);
        List<Character> testData = List.of(
                new Character("1","name1",1,"pro1" ),
                new Character("2","name2",2,"pro2" ));
        when(mockRepo.findAll()).thenReturn(testData);

        //WHEN
        List<Character> actual = asterixService.getAll();

        //THEN
        assertEquals(testData,actual);  //testDaten is expected!
        verify(mockRepo).findAll();     //error: verify(mockRepo.findAll());

    }

    @Test
    void getCharacterById() {
        //GIVEN
        AsterixService asterixService = new AsterixService(mockRepo);
        Character character1 = new Character("1","name1",1,"pro1" );
        //Character character2 = new Character("2","name2",2,"pro2" );
        //List<Character> testData = List.of(character1,character2);

        //when(mockRepo.findById(character1.id())).thenReturn(Optional.of(character1));  //must be Optional.of()!
        when(mockRepo.findById("1")).thenReturn(Optional.of(character1));    //must be Optional.of()!
        when(mockRepo.findById("11")).thenReturn(Optional.empty());      //!don't forget!

        //WHEN
        Character actual1 = asterixService.getCharacterById("1");
        //The type of actual2 is not Character, so this is wrong: Character actual2 = asterixService.getCharacterById("11");

        //THEN
        assertEquals(character1,actual1);
        //assertNotEquals(character2,actual);
        verify(mockRepo).findById("1");

        //'actual2' is defined as a Character, not a Exception !!! This is wrong:  assertThrows(NoSuchElementException.class, () -> actual2);
        assertThrows(NoSuchElementException.class, () -> asterixService.getCharacterById("11"));

        verify(mockRepo).findById("11");

    }

    @Test
    void createCharacter() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void updateCharacterById() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    void deleteCharacterById() {
        //GIVEN

        //WHEN

        //THEN
    }
}