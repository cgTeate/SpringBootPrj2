package git.cgteate.apptest2.ws.springtest2.ui.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.cgteate.apptest2.ws.springtest2.ui.model.Student;
import git.cgteate.apptest2.ws.springtest2.ui.resource.StudentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    
    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }
}
