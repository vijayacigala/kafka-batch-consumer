package com.irene.learning.kafka.producer

import com.irene.learning.kafka.binding.StreamBindings
import com.irene.learning.kafka.model.Registration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.support.GenericMessage
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import java.time.OffsetDateTime

@Service
class RegistrationProducer {
    StreamBindings bindings

    @Autowired
    RegistrationProducer(StreamBindings bindings) {
        this.bindings = bindings
    }

    @Scheduled(cron = "0 0/5 * * * *")
    void send() {
        println "Starting sending messages at ${OffsetDateTime.now()}"
        (1..1000000).parallelStream().each {
            bindings.outboundRegistrations().send(new GenericMessage<Registration>(payload : new Registration(name: "Alice$it", sequenceNumber: it)))
        }
        println "Completed sending messages at ${OffsetDateTime.now()}"
    }
}
