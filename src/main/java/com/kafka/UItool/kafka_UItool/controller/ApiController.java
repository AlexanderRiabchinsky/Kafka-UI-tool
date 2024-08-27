package com.kafka.UItool.kafka_UItool.controller;

import com.kafka.UItool.kafka_UItool.api.Response;
import com.kafka.UItool.kafka_UItool.exeption.EmptyFieldException;
import com.kafka.UItool.kafka_UItool.model.MessagePost;
import com.kafka.UItool.kafka_UItool.model.MessageUpdated;
import com.kafka.UItool.kafka_UItool.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/api/message")
    public ResponseEntity<Response> postMessage(@RequestBody MessagePost messagePost) throws IOException {
        return ResponseEntity.ok(apiService.setMessage(messagePost));
    }

    @PutMapping("/api/message/{id}")
    public ResponseEntity<Response> putMessage(@PathVariable long id, @RequestBody MessageUpdated messageUpdated) throws IOException {
        Optional<MessageUpdated> optionalmessage = Optional.ofNullable(apiService.getOptionalMessageById(id));
        if (optionalmessage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(apiService.updateMessage(messageUpdated));
    }
    @GetMapping("/api/message/{id}")
    public ResponseEntity<MessageUpdated> getMessage(@PathVariable long id) throws EmptyFieldException {
        return ResponseEntity.ok(apiService.getMessageById(id));
    }

    @DeleteMapping("/api/message/{id}")
    public ResponseEntity<Response> deleteMessage(@PathVariable long id) throws IOException {
        return ResponseEntity.ok(apiService.deleteMessageById(id));
    }
    @DeleteMapping("/api/message")
    public ResponseEntity<Response> deleteAllMessages() throws IOException {
        return ResponseEntity.ok(apiService.deleteAllMessages());
    }
}
