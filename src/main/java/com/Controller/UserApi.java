package com.Controller;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private UserRepository repository;
    @PostConstruct
   public void init(){
        User user=new User();
        user.setName("Hello");
        user.setUserName("Mongo");
        repository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(repository.save(user));
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
