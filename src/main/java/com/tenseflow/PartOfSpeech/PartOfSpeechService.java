package com.tenseflow.PartOfSpeech;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PartOfSpeechService {

    void generateWord(){

        Integer randomNumber = (int) (Math.random() * 8) + 1;

        //System.out.println("random number" + randomNumber);
        HashMap<String, String> partOfSpeechMap = listPartOfSpeech();

        String getPartOfSpeech = "", getFile="";

        Integer index = 1;
        for (Map.Entry<String, String> entry : partOfSpeechMap.entrySet()) {
            //String partOfSpeech = entry.getKey();
            //String filename = entry.getValue();
            //System.out.println("index " +index+ " "  + partOfSpeech + " => " + filename);
            if(index.equals(randomNumber)){
              getPartOfSpeech = entry.getKey();
              getFile = entry.getValue();
            }

            index++;
        }

        System.out.println("Random part of speech is " + getPartOfSpeech);
    }

    void readFile() {

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
