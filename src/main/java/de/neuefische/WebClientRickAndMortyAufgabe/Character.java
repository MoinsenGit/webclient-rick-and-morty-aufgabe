package de.neuefische.WebClientRickAndMortyAufgabe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    private int id;
    private String name;
    private String status;// The status of the character ('Alive', 'Dead' or 'unknown').

    //restliche Felder aus Platzgründen nicht mitgenommen

}
