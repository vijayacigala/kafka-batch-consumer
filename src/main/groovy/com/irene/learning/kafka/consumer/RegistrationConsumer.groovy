package com.irene.learning.kafka.consumer

import com.irene.learning.kafka.model.Registration
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.support.GenericMessage
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

import static com.irene.learning.kafka.binding.StreamBindings.ApplicationStreams.REGISTRATIONS_INBOUND

@Service
class RegistrationConsumer {

    static long counter = 0

    @StreamListener(REGISTRATIONS_INBOUND)
    void consume(List<GenericMessage<Registration>> messages) {
        counter += messages.size()
        println "Received ${messages.size()} messages at ${OffsetDateTime.now()} total so far $counter"
    }
}
