package com.project.eCommerce;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//FLYWISE APPLICATION
@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Flight Booking MGMT"))
//@OpenAPIDefinition
public class FlyWise {
	public static void main(String[] args) {SpringApplication.run(FlyWise.class, args);}
}
