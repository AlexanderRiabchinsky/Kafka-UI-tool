package com.kafka.UItool.kafka_UItool.repository;

import com.kafka.UItool.kafka_UItool.model.MessagePost;
import com.kafka.UItool.kafka_UItool.model.MessageUpdated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesPostRepository extends JpaRepository<MessagePost,Long> {
}
