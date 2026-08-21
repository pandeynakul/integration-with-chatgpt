package com.ai.integrationwithchatgpt.controller;

/* author :  Ankul Deshpande */

import com.ai.integrationwithchatgpt.service.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final OpenAIService openAIService;

    public AIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/generate")
    public String generate(@RequestBody String prompt) {
        return openAIService.generateResponse(prompt);
    }
}
