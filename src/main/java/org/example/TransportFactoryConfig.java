package org.example;

import org.springframework.context.annotation.Bean;

public class TransportFactoryConfig {
    @Bean("transport-factory")
    public TransportFactory transportFactory() {
        return new TransportFactory();
    }
}