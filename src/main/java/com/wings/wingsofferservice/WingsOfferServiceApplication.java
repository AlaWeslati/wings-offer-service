package com.wings.wingsofferservice;

import com.wings.wingsofferservice.Service.DemandeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients
public class WingsOfferServiceApplication implements CommandLineRunner {
    @Resource
    DemandeServcie demandeServcie;
    public static void main(String[] args) {
        SpringApplication.run(WingsOfferServiceApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        demandeServcie.init();
    }
}
