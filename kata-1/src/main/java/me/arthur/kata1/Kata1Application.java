package me.arthur.kata1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("me.arthur")
@SpringBootApplication
public class Kata1Application {

	public static void main(String[] args) {
		SpringApplication.run(Kata1Application.class, args);
	}

}
