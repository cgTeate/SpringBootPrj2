package git.cgteate.apptest2.ws.springtest2.ui.resource;

import java.util.List;

import org.springframework.stereotype.Service;

import git.cgteate.apptest2.ws.springtest2.ui.model.Student;
import git.cgteate.apptest2.ws.springtest2.ui.repository.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
