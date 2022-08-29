package git.cgteate.apptest2.ws.springtest2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import git.cgteate.apptest2.ws.springtest2.ui.model.Address;
import git.cgteate.apptest2.ws.springtest2.ui.model.Gender;
import git.cgteate.apptest2.ws.springtest2.ui.model.Student;
import git.cgteate.apptest2.ws.springtest2.ui.repository.StudentRepository;

@SpringBootApplication
public class Springtest2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springtest2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address = new Address(
				"England",
				"London",
				"NE9"
			);

			Student student = new Student(
				"Jamila",
				"Ahmed",
				"jahmed@gmail.com",
				Gender.FEMALE,
				address,
				List.of("Computer Science", "Mathematics"),
				BigDecimal.TEN,
				LocalDateTime.now()
			);
			repository.insert(student);
		};
	}

}
