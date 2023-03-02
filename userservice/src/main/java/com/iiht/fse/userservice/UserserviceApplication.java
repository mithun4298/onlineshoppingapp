package com.iiht.fse.userservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import java.util.function.Supplier;

@SpringBootApplication
public class UserserviceApplication {

	//private static AbstractLogger logger = logFactory.getLog();

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
