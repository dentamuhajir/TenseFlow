package com.tenseflow.PartOfSpeech;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PartOfSpeechService {

    void generateWord(){

        HashMap<String, String> partOfSpeechMap = listPartOfSpeech();

        for (Map.Entry<String, String> entry : partOfSpeechMap.entrySet()) {
            String partOfSpeech = entry.getKey();
            String filename = entry.getValue();
            System.out.println(partOfSpeech + " => " + filename);
        }
    }

    HashMap<String, String> listPartOfSpeech() {
        HashMap<String, String> listDataset = new HashMap<>();
        listDataset.put("Adjective" , "adjective.txt");
        listDataset.put("Adverb", "adverb.txt");
        listDataset.put("Conjunction", "conjuction.txt");
        listDataset.put("Interjections", "Interjections.txt");
        listDataset.put("Noun", "noun.txt");
        listDataset.put("Preposition", "preposition.txt");
        listDataset.put("Pronoun", "pronoun.txt");
        listDataset.put("Verb", "verbs.csv");
        return listDataset;
    }
}
