package com.kafka.UItool.kafka_UItool.service;

import com.kafka.UItool.kafka_UItool.api.Response;
import com.kafka.UItool.kafka_UItool.exeption.EmptyFieldException;
import com.kafka.UItool.kafka_UItool.model.MessagePost;
import com.kafka.UItool.kafka_UItool.model.MessageUpdated;
import com.kafka.UItool.kafka_UItool.repository.MessagesPostRepository;
import com.kafka.UItool.kafka_UItool.repository.MessagesUpdatedRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final MessagesUpdatedRepository messagesUpdatedRepository;
    private final MessagesPostRepository messagesPostRepository;

    public Response setMessage(MessagePost messagePost) {
        Response response = new Response();
        if (messagePost.getCode() != null && messagePost.getLabel() != null) {
            messagesPostRepository.save(messagePost);
            response.setResponse(true);
        } else response.setResponse(false);
        return response;
    }

    public MessageUpdated getOptionalMessageById(long id) {
        return messagesUpdatedRepository.getOptionalMessageById(id);
    }

    public Response updateMessage(MessageUpdated messageUpdated) {
        Response response = new Response();
        if (messageUpdated.getCode() != null && messageUpdated.getLabel() != null && messageUpdated.getId() != null) {
            messagesUpdatedRepository.save(messageUpdated);
            response.setResponse(true);
        } else response.setResponse(false);
        return response;
    }

    public MessageUpdated getMessageById(long id) throws EmptyFieldException {
        return messagesUpdatedRepository.findById(id).orElseThrow();
    }

    public Response deleteMessageById(long id) {
        Response response = new Response();
        messagesUpdatedRepository.deleteById(id);
        response.setResponse(true);
        return response;
    }

    public Response deleteAllMessages() {
        Response response = new Response();
        messagesUpdatedRepository.deleteAll();
        response.setResponse(true);
        return response;
    }
}
