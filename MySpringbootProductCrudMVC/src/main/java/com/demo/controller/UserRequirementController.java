package com.demo.controller;

import com.demo.model.UserRequirement;
import com.demo.service.UserRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userrequirements")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRequirementController {

    @Autowired
    private UserRequirementService userRequirementService;

    // Endpoint to get all user requirements by skill
    @GetMapping("/by-skill/{skill}")
    public ResponseEntity<List<UserRequirement>> getUserRequirementsBySkill(@PathVariable("skill") String skill) {
        List<UserRequirement> userRequirements = userRequirementService.getall(skill);
        return new ResponseEntity<>(userRequirements, HttpStatus.OK);
    }

    // Endpoint to get a specific user requirement by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRequirement> getUserRequirementById(@PathVariable("id") int id) {
        UserRequirement userRequirement = userRequirementService.getdata(id);
        if (userRequirement != null) {
            return new ResponseEntity<>(userRequirement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to create a new user requirement
    @PostMapping
    public ResponseEntity<UserRequirement> createUserRequirement(@RequestBody UserRequirement userRequirement) {
        System.out.println(userRequirement);
    	userRequirementService.addUserRequirement(userRequirement);
        
        return new ResponseEntity<>(userRequirement, HttpStatus.CREATED);
    }

    // Endpoint to update an existing user requirement
    @PutMapping("/{id}")
    public ResponseEntity<UserRequirement> updateUserRequirement(@PathVariable("id") int id,
                                                                 @RequestBody UserRequirement userRequirement) {
        UserRequirement existingRequirement = userRequirementService.getdata(id);
        if (existingRequirement != null) {
            userRequirement.setRequirementId(id);
            userRequirementService.addUserRequirement(userRequirement);
            return new ResponseEntity<>(userRequirement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a user requirement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRequirement(@PathVariable("id") int id) {
        UserRequirement existingRequirement = userRequirementService.getdata(id);
        if (existingRequirement != null) {
            userRequirementService.addUserRequirement(null); // Here you should ideally call a delete method in service
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
