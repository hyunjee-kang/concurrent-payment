package com.example.concurrentpayment;

import org.springframework.boot.SpringApplication;

public class TestConcurrentPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.from(ConcurrentPaymentApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
