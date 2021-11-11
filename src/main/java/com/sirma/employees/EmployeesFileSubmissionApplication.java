package com.sirma.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesFileSubmissionApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesFileSubmissionApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeesFileSubmissionApplication.class, args);

        LOGGER.info("PLEASE OPEN THE FOLLOWING URI TO SUBMIT EMPLOYEES FILE\n" + "http://localhost:8080/submit-file");
    }

}
