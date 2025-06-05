package com.assignment.incredit.config;


import com.fasterxml.jackson.databind.Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonConfig {
	
	@Bean
    public Module javaTimeModule() {
        return new JavaTimeModule();
    }

}
