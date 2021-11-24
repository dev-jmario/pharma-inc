package com.challenge.pharmainc.controller;

import com.challenge.pharmainc.model.User;
import com.challenge.pharmainc.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CrudController {

    @Autowired
    private CrudService crudService;

    @GetMapping("/")
    public ResponseEntity<String> message(){
        return ResponseEntity.ok().body(crudService.message());
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId")Integer id){
        User user = crudService.findById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(crudService.updateUser(user));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId")Integer id){
        User user = crudService.findById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        else{
            crudService.deleteUser(user);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> findById(@PathVariable("userId")Integer id){
        User user = crudService.findById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(crudService.findAll());
    }

}
