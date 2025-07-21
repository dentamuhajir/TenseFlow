package com.tenseflow.PartOfSpeech;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/part-of-speech")
public class PartOfSpeechController {
    private PartOfSpeechService partOfSpeechService;
    public ResponseEntity<?> generate(){
        partOfSpeechService.generateWord();
        return ResponseEntity.ok("it works");
    }

}
