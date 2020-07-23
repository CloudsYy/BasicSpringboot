package com;

import com.cloud.BasicSpringboot.ProcessTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicSpringbootApplication.class);
        ProcessTest process = new ProcessTest();
        Thread thread = new Thread(process);
        thread.setName("线程Process");
        thread.start();
    }

}
