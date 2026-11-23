package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping ("/users")
public class UserController{

private UserService userService;

public UserController(UserService userService){
    this.userService=userService;
}

@PostMapping
public ResponseEntity<User> saveUser(@RequestBody User user){
    User object= userService.saveUser(user);
    if (object!=null) {
      return   ResponseEntity.status(HttpStatus.CREATED).build();
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}


    @GetMapping ("/{id}")
    public ResponseEntity<User> getUserData(@PathVariable Long id){
       Optional<User> useropt =   userService.getUser(id);
            if (useropt.isPresent()) {
               return new ResponseEntity(useropt.get(),HttpStatus.OK);
             }
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }

     @GetMapping 
     public ResponseEntity<List<User>> getAllUser(){
       List<User> object= userService.getAllUser();
       return ResponseEntity.status(HttpStatus.OK).body(object);
     }
      @DeleteMapping ("/{id}")
      public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

      }
      @PutMapping ("/{id}")
      public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody  User user){
        User object =userService.updateUser(user, id);
        return ResponseEntity.status(HttpStatus.OK).body(object);
      }

    }

