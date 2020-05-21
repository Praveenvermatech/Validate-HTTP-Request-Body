package com.developervisits.controller;

import com.developervisits.model.UserDetailModel;
import com.developervisits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
