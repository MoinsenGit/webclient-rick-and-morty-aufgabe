package de.neuefische.WebClientRickAndMortyAufgabe.controller;

import de.neuefische.WebClientRickAndMortyAufgabe.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import de.neuefische.WebClientRickAndMortyAufgabe.Character;
@RestController
public class RickUndMortyController {

    @GetMapping("/character")
    public List<Character> allCharacters () {
        WebClient getWebClient = WebClient.create(
                "https://rickandmortyapi.com/api"
        );

        List<Character> allCharacters = new ArrayList<>();


        for (int i = 1; i <= 42; i++) {
            String uri = "/character/?page=" + i;

            Results results = getWebClient.get()
                    .uri(uri)
                    .retrieve()
                    .toEntity(Results.class)
                    .block()
                    .getBody();

            allCharacters.addAll(results.getResults());
        }
        return allCharacters;
    }
 @GetMapping("alive")
    public List<Character> allAliveCharacters () {
     WebClient getWebClient = WebClient.create(
             "https://rickandmortyapi.com/api"
     );
     List<Character> allCharacters = new ArrayList<>();

     for (int i = 1; i <= 22; i++) {
         String uri = "/character/?status=alive&page=" + i;

         Results results = getWebClient.get()
                 .uri(uri)
                 .retrieve()
                 .toEntity(Results.class)
                 .block()
                 .getBody();
            allCharacters.addAll(results.getResults());
        }
        return allCharacters;
    }





}
