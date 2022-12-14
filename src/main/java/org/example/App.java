package org.example;

import org.example.config.LogisticsConfig;
import org.example.config.TransportFactoryConfig;
import org.example.services.Logistics;
import org.example.services.TransportFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LogisticsConfig.class);
        Logistics logistics = context.getBean(Logistics.class);
        logistics.sayHello();

        ApplicationContext context1 = new AnnotationConfigApplicationContext(TransportFactoryConfig.class);
        TransportFactory transportFactory = (TransportFactory) context1.getBean("transport-factory");
        transportFactory.sayHelloFactory();
    }
}