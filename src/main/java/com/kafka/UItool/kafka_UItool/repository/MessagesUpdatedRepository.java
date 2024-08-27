package com.kafka.UItool.kafka_UItool.repository;

import com.kafka.UItool.kafka_UItool.model.MessageUpdated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessagesUpdatedRepository extends JpaRepository<MessageUpdated,Long> {
    @Query(value = "SELECT * FROM messages_updated WHERE id =:id ",
            nativeQuery = true)
    MessageUpdated getOptionalMessageById(@Param("id") long id);
}
