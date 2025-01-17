package com.tests.geocodertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class GeocoderTaskApplication {
    private static final Logger logger = LoggerFactory.getLogger(GeocoderTaskApplication.class);

    public static void main(String[] args) {
        System.out.println("Started");
        logger.info("Приложение запущено");
        logger.debug("Отладочное сообщение");
        logger.warn("Предупреждение");
        logger.error("Ошибка");
        //SpringApplication.run(GeocoderTaskApplication.class, args);
        System.out.println("Hello world!");
    }

}
