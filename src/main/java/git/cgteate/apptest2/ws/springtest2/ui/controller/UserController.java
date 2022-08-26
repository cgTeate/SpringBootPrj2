package git.cgteate.apptest2.ws.springtest2.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.cgteate.apptest2.ws.springtest2.ui.model.request.UserDetailRequestModel;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    
    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public String createUser(@RequestBody UserDetailRequestModel userDet) {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
