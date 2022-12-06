package de.neuefische.WebClientRickAndMortyAufgabe.controller;

import de.neuefische.WebClientRickAndMortyAufgabe.Character;
import de.neuefische.WebClientRickAndMortyAufgabe.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RickUndMortyController2 {

    private static List<Character> getCharacters(int numberOfPages, String baseUri) {
        WebClient getWebClient = WebClient.create(
                "https://rickandmortyapi.com/api"
        );

        List<Character> allCharacters = new ArrayList<>();


        for (int i = 1; i <= numberOfPages; i++) {
            String uri = baseUri + i;

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

    @GetMapping("/character2")
    public List<Character> allCharacters () {
        return getCharacters(42, "/character/?page=");
    }

    @GetMapping("alive2")
    public List<Character> allAliveCharacters () {
        return getCharacters(22, "/character/?status=alive&page=");
    }
}
