package com.kafka.UItool.kafka_UItool.model;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagePost {
    @Column
    private String code;
    @Column
    private String label;
}
