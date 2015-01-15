package co.eltiempo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
@EnableAutoConfiguration
public class Application {
	public static void main(String args[]){
		SpringApplication.run(Application.class, args);
	}
}
