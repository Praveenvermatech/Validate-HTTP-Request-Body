package com.developervisits.controller;

import com.developervisits.model.UserDetailModel;
import com.developervisits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired(required = true)
    private UserService service;

    public void UserController(UserService service){
        this.service = service;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDetailModel> createUser(@Valid @RequestBody UserDetailModel requestUserDetails) {

        UserDetailModel model = service.saveUser(requestUserDetails);

        return ResponseEntity.ok( model);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDetailModel>> getUSerList(){
        List<UserDetailModel> model = service.retrieveUsers();
        return ResponseEntity.ok(model);
    }
}
