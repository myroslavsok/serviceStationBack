package com.example.demo;

import com.example.demo.domains.Client;
import com.example.demo.domains.DTO.CarInfo;
import com.example.demo.domains.DTO.ClientInfo;
import com.example.demo.domains.car.Car;
import com.example.demo.domains.car.Make;
import com.example.demo.domains.car.Model;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MakeRepository;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private ModelRepository modelRepository;

	@Autowired
	private MakeRepository makeRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setDefaultsEntitiesInDB() {

		System.out.println("\n \n \n \n \n \n Starts \n \n \n \n \n \n");

		String unsetValue = "Не вказано";
		long defaultSequenceId = 1;

		// add default make
		Make make = new Make(defaultSequenceId, unsetValue);
		makeRepository.save(make);

		// add default model
		Model model = new Model(defaultSequenceId, unsetValue, make);
		modelRepository.save(model);

		// add default client
		ClientInfo clientInfo = new ClientInfo(unsetValue, unsetValue);
		Client client = new Client(defaultSequenceId, clientInfo);
		clientRepository.save(client);

		// add default car
		CarInfo carInfo = new CarInfo(unsetValue, unsetValue, unsetValue, unsetValue, unsetValue, unsetValue);
		Car car = new Car(defaultSequenceId, carInfo, model);
		carRepository.save(car);

	}
}
