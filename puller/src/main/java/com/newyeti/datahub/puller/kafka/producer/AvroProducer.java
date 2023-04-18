package com.newyeti.datahub.puller.kafka.producer;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.newyeti.datahub.puller.avro.schema.Team;
import com.newyeti.datahub.puller.kafka.config.KafkaConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AvroProducer {

    private final KafkaTemplate<String, Team> kafkaTemplate;
    private final KafkaConfig kafkaConfig;

    public void send(Team team) {
        CompletableFuture<SendResult<String, Team>> future = kafkaTemplate
            .send(kafkaConfig.getTopic(), String.valueOf(team.getId()), team);
            
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Message sent successfully. Message = {} ", result);
            } else {
                log.error("Unable to send message due to : {} ", ex.getMessage(), ex);
            }
        });
    }

}
