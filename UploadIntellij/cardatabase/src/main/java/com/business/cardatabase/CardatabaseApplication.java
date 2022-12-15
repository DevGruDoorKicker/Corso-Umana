package com.business.cardatabase;

import com.business.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	// Dependency Injection
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository userRepository;


	// new comment
	public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("fulvio", "fulviolast");
		orepository.save(owner1);

		repository.save(new Car("Ford1", "Mustang1", "Red", "AM-21", 2021, 60000, owner1));
		repository.save(new Car("Ford2", "Mustang2", "Red", "AM-21", 2021, 60000, owner1));
		repository.save(new Car("Ford3", "Mustang3", "Red", "AM-21", 2021, 60000, owner1));

		for (Car c: repository.findAll()) {
			logger.info(c.getBrand());
		}

		//user creation and persistance
		User u1= new User("admin","$2a$10$gyIZaowJC2nuiKaIAgMTqugDBP7b3gCiRXPd5wno693.wSK1Q4ARm","ADMIN");
		User u2= new User("indesiderabile","$2a$10$W4Kzz06sXDKmhpLXiH9Fp.IAp.impR5BTgHgDf2E6p0dnnmAYWOXK","USER");

		userRepository.save(u1);
		userRepository.save(u2);
	}
}
