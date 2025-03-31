package br.com.daviAlves22.Aprendendo_spring_boot_e_java.controllers;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.services.PersonServices;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
public class TestLogController {

    private  Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog() {
        logger.debug("Isso é uma mensagem de DEBUG log");
        logger.warn("Isso é uma mensagem de WARNING log");
        logger.info("Isso é uma mensagem de INFO log");
        logger.error("Isso é uma mensagem de ERROR log");
        return "Logs gerados com sucesso!";

    }
}