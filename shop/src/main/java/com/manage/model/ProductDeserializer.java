package com.manage.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ProductDeserializer extends ObjectMapperDeserializer<Product> {
    public ProductDeserializer() {
        super(Product.class);
    }
}
