package com.newyeti.datahub.puller.kafka.producer;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.newyeti.datahub.puller.avro.schema.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvroProducer {

    private final KafkaTemplate<String, Team> kafkaTemplate;

    @Value("${avro.topic.name}")
    private final String topic;

    public void send(Team team) {
        CompletableFuture<SendResult<String, Team>> future = kafkaTemplate.send(topic, String.valueOf(team.getId()), team);
        
    }


}
