package com.example.demomvcapi;

import com.example.demomvcapi.entity.Student;
import com.example.demomvcapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMvcApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvcApiApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Mateo", "Roza", "mateoroza@gmail.com");
		studentRepository.save(student1);

		Student student2 = new Student("Mateo2", "Roza2", "mateoroza2@gmail.com");
		studentRepository.save(student2);

		Student student3 = new Student("Mateo3", "Roza3", "mateoroza3@gmail.com");
		studentRepository.save(student3);

	}
}
