package com.ai.integrationwithchatgpt.config;

/* author :  Ankul Deshpande */

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiConfig {

    @Value("${openai.api.key}")
    String openaiApiKey;
    @Value("${openai.api.url}")
    String apiUrl;

    @Bean
    public OpenAIClient openAIClient() {
        return OpenAIOkHttpClient.builder()
                .apiKey(openaiApiKey)
                .baseUrl(apiUrl)
                .build();
    }
}
