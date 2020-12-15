package com.appliances.appliances.web.config;

import com.appliances.appliances.web.client.ProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.appliances.appliances.web.model");
        return marshaller;
    }

    @Bean
    public ProductClient productClient(Jaxb2Marshaller marshaller) {
        ProductClient client = new ProductClient();
        client.setDefaultUri("http://localhost:8080/ws/products");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
