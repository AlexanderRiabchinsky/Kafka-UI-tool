package com.kafka.UItool.kafka_UItool.repository;

import com.kafka.UItool.kafka_UItool.model.MessagePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesPostRepository extends JpaRepository<MessagePost,Long> {
}
