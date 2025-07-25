package com.tenseflow.Tenses;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tenses")
public class TensesAnalyzerController {
    private TensesAnalyzerService tensesAnalyzerService;
    @PostMapping(value = "/analyzer")
    ResponseEntity<?> tensesAnalyzer(@RequestBody Map<String, String> requestBody) {
        String sentence = requestBody.get("sentence");
        tensesAnalyzerService.simplePresentTense(sentence);
        return ResponseEntity.ok("Analyze Tenses");
    }
}
