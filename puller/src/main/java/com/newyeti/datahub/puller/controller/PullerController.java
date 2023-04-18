package com.newyeti.datahub.puller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.newyeti.datahub.puller.avro.schema.Team;
import com.newyeti.datahub.puller.kafka.producer.AvroProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/puller")
@RequiredArgsConstructor
public class PullerController {

  private final AvroProducer avroProducer;
  
  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public String send(@RequestBody Team team) {
    avroProducer.send(team);
    return "OK";
  }

}
