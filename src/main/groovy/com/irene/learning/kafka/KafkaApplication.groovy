package com.irene.learning.kafka

import com.irene.learning.kafka.binding.StreamBindings
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableBinding(StreamBindings)
class KafkaApplication {
    static void main(String[] args) {
        SpringApplication.run(KafkaApplication, args)
    }
}
