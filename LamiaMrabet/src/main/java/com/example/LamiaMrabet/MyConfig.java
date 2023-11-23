package com.example.LamiaMrabet;

import com.example.LamiaMrabet.web.RestJaxrs;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    ResourceConfig resourceConfig(){

        ResourceConfig resourceConfig =new ResourceConfig();
        resourceConfig.register(RestJaxrs.class);
        return  resourceConfig;
    }
}
