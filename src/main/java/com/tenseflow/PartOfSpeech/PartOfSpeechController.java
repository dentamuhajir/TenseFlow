package com.tenseflow.PartOfSpeech;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping(value = "/analyze")
    public ResponseEntity<?> analyzePOS(@RequestBody Map<String, String> requestBody) {
        String word =  requestBody.get("word");
        partOfSpeechService.analyzePOS(word);
        return  ResponseEntity.ok("analyze");

    }

}
