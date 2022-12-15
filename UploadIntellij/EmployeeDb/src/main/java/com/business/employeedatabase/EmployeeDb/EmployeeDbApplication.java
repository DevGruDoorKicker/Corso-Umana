package com.business.employeedatabase.EmployeeDb;

import com.business.employeedatabase.EmployeeDb.domain.Employee;
import com.business.employeedatabase.EmployeeDb.domain.EmployeeRepository;
import com.business.employeedatabase.EmployeeDb.web.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDbApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(EmployeeDbApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		employeeRepository.save(new Employee("Giggi", "ilMerda"));

		for (Employee e : employeeRepository.findAll()) {
			e.getId();
		}







	}

}