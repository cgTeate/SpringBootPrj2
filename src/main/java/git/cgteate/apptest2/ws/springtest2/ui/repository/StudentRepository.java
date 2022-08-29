package git.cgteate.apptest2.ws.springtest2.ui.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import git.cgteate.apptest2.ws.springtest2.ui.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
    
}
