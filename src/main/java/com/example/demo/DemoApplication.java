package com.example.demo;

import com.example.demo.domains.car.Make;
import com.example.demo.domains.car.Model;
import com.example.demo.repositories.MakeRepository;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	MakeRepository makeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setDefaultsEntitiesInDB() {

		System.out.println("\n \n \n \n \n \n Starts \n \n \n \n \n \n");

		String unsetValue = "Не вказано";

		Make make = new Make(Long.valueOf("1"), unsetValue);
		makeRepository.save(make);


		List<Model> defaultEntityModels = modelRepository.findByModelName(unsetValue);
		if (defaultEntityModels.size() == 0) {
			Model model = new Model(Long.valueOf("2"), unsetValue, make);
			modelRepository.save(model);
			System.out.println("add");
		}

		System.out.println("don't add");
		defaultEntityModels.forEach(model -> System.out.println(model.getId() + "  " + model.getModelName()));
	}
}
