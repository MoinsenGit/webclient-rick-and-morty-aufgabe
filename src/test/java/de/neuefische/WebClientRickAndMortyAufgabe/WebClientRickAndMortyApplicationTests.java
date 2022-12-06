package de.neuefische.WebClientRickAndMortyAufgabe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class WebClientRickAndMortyApplicationTests {

    //Aufgabe WebClient
    //Nutze den WebClient, um Daten von der Rick & Morty API zu laden.
    //Stelle einen WebClient Service bereit, der verschiedene Informationen aus der Rick & Morty API laden kann
    //Lies alle Charaktere aus
    //Lies alle lebenden Charaktere aus - https://rickandmortyapi.com/api/character/?status=alive

    @Test
    void webclientRickAndMortyAllCharacters () {
        WebClient getWebClient = WebClient.create(
                "https://rickandmortyapi.com/api"
        );

        for (int i = 1; i <= 42; i++) {
            String uri = "/character/?page=" + i;

            // nacheinander ausgeben

            Results results = getWebClient.get()
                    .uri(uri)
                    .retrieve()
                    .toEntity(Results.class)
                    .block()
                    .getBody();

            System.out.println(results);
        }

    }

        @Test
        void webclientRickAndMortyAliveCharacters () {
            WebClient getWebClient = WebClient.create(
                    "https://rickandmortyapi.com/api"
            );

            for (int i = 1; i <= 22; i++) {
                String uri = "/character/?status=alive&page=" + i;

                // nacheinander ausgeben

                Results results = getWebClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(Results.class)
                        .block()
                        .getBody();

                System.out.println(results);
            }

    }

}
