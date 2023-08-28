package com.keelient.spring_batch_001;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
//@ComponentScan("com.keelient.spring_batch_001.config")
public class SpringBatch001Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatch001Application.class, args);
	}

}
