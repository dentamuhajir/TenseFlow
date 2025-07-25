package com.tenseflow.Tenses;

import com.tenseflow.PartOfSpeech.PartOfSpeechService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class TensesAnalyzerService {

    private PartOfSpeechService partOfSpeechService;

    public void simplePresentTense(String sentence){
        Map<String, String> posTagged = partOfSpeechService.generatePartOfSpeech(sentence);

        for(Map.Entry<String, String> tag : posTagged.entrySet()){
            System.out.println(tag.getKey() + " => " + tag.getValue());
        }


    }
}
