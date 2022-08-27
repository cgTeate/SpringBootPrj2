package git.cgteate.apptest2.ws.springtest2.ui.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
/* 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;*/
import org.springframework.web.bind.annotation.RestController;

import git.cgteate.apptest2.ws.springtest2.ui.model.User;
import git.cgteate.apptest2.ws.springtest2.ui.repository.UserRepository;
import git.cgteate.apptest2.ws.springtest2.ui.resource.UserRequest;

@RestController
//@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    /*create a user
     * set the name and description from the one passed in the request
     * then the user gets saved to the database
     * then return the user back
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
       
        User user = new User();
        user.setName(userRequest.getName());
        user.setDescription(userRequest.getDescription());
       
        return ResponseEntity.status(201).body(this.userRepository.save(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable String id) {

        Optional<User> user = this.userRepository.findById(id);
        
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.ok("The user " + id + " does not exist");
    }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable String id) {

        Optional<User> user = this.userRepository.findById(id);
        
        if(user.isPresent()) {
            this.userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.ok("The user " + id + " does not exist");
    }
    }
    /*

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    
    } */
    
}
