package com.tenseflow.PartOfSpeech;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/part-of-speech")
public class PartOfSpeechController {
    private PartOfSpeechService partOfSpeechService;
    @GetMapping(value = "/generate")
    public ResponseEntity<?> generate(){
        partOfSpeechService.generateWord();
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value = "/analyze")
    public ResponseEntity<?> analyzePOS() {
        partOfSpeechService.analyzePOS();
        return  ResponseEntity.ok("analyze");

    }

}
