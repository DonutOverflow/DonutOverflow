package Unibuc.DonutBros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Donut.Donut;
import Donut.DonutRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DonutBrosApplication {
//	private static DonutRepository donutRepository;
//
//	public DonutBrosApplication(DonutRepository donutRepository1) {
//		donutRepository = donutRepository1;
//	}

	public static void printMenu(String[] options){
		for (String option : options){
			System.out.println(option);
		}
		System.out.print("Choose your option : ");
	}

	public static void main(String[] args) {

		SpringApplication.run(DonutBrosApplication.class, args);
	}

}
