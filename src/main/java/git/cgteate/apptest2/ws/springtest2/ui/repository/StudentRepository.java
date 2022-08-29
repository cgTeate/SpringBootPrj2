package git.cgteate.apptest2.ws.springtest2.ui.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import git.cgteate.apptest2.ws.springtest2.ui.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
    Optional<Student> findStudentByEmail(String email);
}
