package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:5713")

public class SmartBotController {

        private ChatClient chatClient;

        public SmartBotController(OllamaChatModel chatModel)
        {
            this.chatClient=ChatClient.create(chatModel);
        }

        @PostMapping("/recommend")


        @GetMapping("/{message}")
        public ResponseEntity<String> getAnswer(@PathVariable String message)
        {
            ChatResponse chatResponse=chatClient.
                    prompt(message)
                .call()
                .chatResponse();


            System.out.println(chatResponse.getMetadata().getModel());


            String response = chatResponse
                    .getResult()
                    .getOutput()
                    .getText();

            return ResponseEntity.ok(response);
        }
}
