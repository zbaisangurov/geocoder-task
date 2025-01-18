package com.tests.geocodertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class GeocoderTaskApplication {
    //private static final Logger logger = LoggerFactory.getLogger(GeocoderTaskApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GeocoderTaskApplication.class, args);
    }

}
