package com.nfebrian13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nfebrian13.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringbootMybatisJasperApplication implements CommandLineRunner {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisJasperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("Student id 10001 -> {}", studentService.findById(10001L));
		LOGGER.info("All users -> {}", studentService.findAll());
	}

}
