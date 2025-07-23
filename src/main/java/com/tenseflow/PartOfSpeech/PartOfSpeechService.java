package com.tenseflow.PartOfSpeech;

import org.springframework.core.io.ClassPathResource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
              break;
            }

            index++;
        }

        //System.out.println("Random part of speech is " + getPartOfSpeech);

        List<String> listWord = readFile(getFile);

        int totalWord = listWord.size();
        Integer randomWord = (int) (Math.random() * totalWord) + 1;
        Integer indexWord = 1;
        String word = "";
        for(String list: listWord ){
            if(indexWord.equals(randomWord)) {
                word = list;
            }
            indexWord++;
            //System.out.println(list);
        }

        System.out.println("Word : " + word + " | " + getPartOfSpeech);
    }

    public List<String> readFile(String randomFile) {
        List<String> adjectives = new ArrayList<>();

        try {
            ClassPathResource resource = new ClassPathResource("dataset/kaggle/part_of_speech_collection/" + randomFile);
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                adjectives.add(line.trim());
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace(); // You can use proper logging
        }

        return adjectives;
    }

    HashMap<String, String> listPartOfSpeech() {
        HashMap<String, String> listDataset = new HashMap<>();
        listDataset.put("Adjective" , "adjective.txt");
        listDataset.put("Adverb", "adverb.txt");
        listDataset.put("Conjunction", "conjunction.txt");
        listDataset.put("Interjections", "Interjections.txt");
        listDataset.put("Noun", "noun.txt");
        listDataset.put("Preposition", "preposition.txt");
        listDataset.put("Pronoun", "pronoun.txt");
        listDataset.put("Verb", "verb.txt");
        return listDataset;
    }
}
