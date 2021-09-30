package com.manage.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class TrackingDeserializer extends ObjectMapperDeserializer<Tracking> {
    public TrackingDeserializer() {
        super(Tracking.class);
    }
}
