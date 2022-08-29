package git.cgteate.apptest2.ws.springtest2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
	CommandLineRunner runner(
		StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address(
				"England",
				"London",
				"NE9"
			);
			
			String email = "jahmed@gmail.com";
			Student student = new Student(
				"Jamila",
				"Ahmed",
				email,
				Gender.FEMALE,
				address,
				List.of("Computer Science", "Mathematics"),
				BigDecimal.TEN,
				LocalDateTime.now()
			);

			//usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);

			repository.findStudentByEmail(email)
				.ifPresentOrElse(s -> {
					System.out.println(s + " already exists");
				}, () ->{
					System.out.println("Inserting student " + student);
					repository.insert(student);
				});
			
		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if(students.size() > 1){
			throw new IllegalStateException("found many students with email " + email);
		}

		if(students.isEmpty()){
			System.out.println("Inserting student " + student);
			repository.insert(student);
		} else{
			System.out.println(student + " already exists");
		}
	}

}
