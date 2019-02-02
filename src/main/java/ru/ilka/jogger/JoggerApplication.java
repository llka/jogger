package ru.ilka.jogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoggerApplication {

    private static Logger logger = LogManager.getLogger(JoggerApplication.class);

    public static void main(String[] args) {
        logger.debug("run");
        SpringApplication.run(JoggerApplication.class, args);
    }

}

