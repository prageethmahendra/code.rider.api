package com.code.rider.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RequestMapping("/hello-world")
public class Application {

	@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public Employee init(){
		Employee employee = new Employee();
		employee.setFirstName("Code ");
		employee.setLastName("Rider");
		employee.setTitle("Mr");
		employeeRepository.save(employee);
		return employee;
	}

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(method= RequestMethod.GET, value = "/up", headers = "content-type=text/*")
	public @ResponseBody
	Employee sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
		Employee employee = init();
		employee.setFirstName(employee.getFirstName() + counter.floatValue());
		return employee;
	}
}
