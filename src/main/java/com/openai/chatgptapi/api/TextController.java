package com.openai.chatgptapi.api;

import com.openai.chatgptapi.domain.model.TextGenerate;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/text")
public class TextController {

    @Value("${openai.token}")
    private String TOKEN_OPEN_AI;

    @PostMapping
    public ResponseEntity<?> generate(@RequestBody TextGenerate textGenerate) {
        try {
            OpenAiService service = new OpenAiService(TOKEN_OPEN_AI);

            CompletionRequest completionRequest = CompletionRequest.builder()
                    .prompt(textGenerate.getQuestion())
                    .model("text-davinci-003")
                    .maxTokens(4000)
                    .temperature(textGenerate.getTemperature())
                    .build();
            return ResponseEntity.ok(service.createCompletion(completionRequest).getChoices());
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
