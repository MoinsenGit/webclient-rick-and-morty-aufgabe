package de.neuefische.WebClientRickAndMortyAufgabe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private List<Character> results;

    private Info info;
}
