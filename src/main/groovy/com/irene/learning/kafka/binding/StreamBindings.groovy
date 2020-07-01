package com.irene.learning.kafka.binding

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface StreamBindings {
    interface ApplicationStreams {
        final static String REGISTRATIONS_INBOUND = "registrations-inbound"
        final static String REGISTRATIONS_OUTBOUND = "registrations-outbound"
    }

    @Input(ApplicationStreams.REGISTRATIONS_INBOUND)
    MessageChannel inboundRegistrations()

    @Output(ApplicationStreams.REGISTRATIONS_OUTBOUND)
    MessageChannel outboundRegistrations()
}
