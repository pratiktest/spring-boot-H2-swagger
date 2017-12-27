package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Spring Boot aims to help developers create applications that "just run." To that end, it packages your application and its dependencies into a single, executable JAR. To run your application, you start Java like this:

 $ java -jar PATH_TO_EXECUTABLE_JAR/executableJar.jar

 */
public class BookstoreApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
