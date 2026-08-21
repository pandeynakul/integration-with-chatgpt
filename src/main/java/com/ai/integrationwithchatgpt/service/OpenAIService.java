package com.ai.integrationwithchatgpt.service;

/* author :  Ankul Deshpande */

import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    private final OpenAIClient openAIClient;
    @Value("${openai.model}")
    private String model;

    public OpenAIService(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    public String generateResponse(String prompt) {

        ResponseCreateParams params = ResponseCreateParams.builder()
                .model(model)
                .input(prompt)
                .build();

        Response response = openAIClient.responses().create(params);

        return response.toString();
    }
}
