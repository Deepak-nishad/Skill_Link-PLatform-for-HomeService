package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.model.UserRequirement;
import com.demo.service.ServiceProviderServ;
import com.demo.service.UserRequirementService;
import com.demo.service.UserService;

@RequestMapping("/skilllink")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRequirementService userRequire;

    @Autowired
    private ServiceProviderServ servProv;

    @PostMapping("/registration")
    public ResponseEntity<?> addUser(@RequestBody User u) {
        System.out.println(u.toString());
        User ul = userService.addUser(u);

        if (ul == null) {
            return ResponseEntity.ok("fail");
        }
        return ResponseEntity.ok("success");
    }

    @PostMapping("/login")
    public ResponseEntity<?> validate(@RequestBody User u) {
        User login = userService.validate(u.getUsername(), u.getPassword());

        if (login != null) {
            System.out.println(login.toString());
            System.out.println("success");
            return ResponseEntity.ok(login);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAll() {
        System.out.println("inside getAll");
        List<User> ulist = userService.getAll();
        if (ulist.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(ulist);
    }

    @PostMapping("/insertUserRequirement")
    public ResponseEntity<?> insertUserRequirement(@RequestBody UserRequirement u) {
        System.out.println(u.toString());
        userRequire.addUserRequirement(u);
        return ResponseEntity.ok("data added successfully");
    }

    @PostMapping("/addRating/{sid}/{rate}")
    public ResponseEntity<?> addRating(@PathVariable int sid, @PathVariable int rate) {
        float rating = servProv.getRating(sid);
        float avg = (rating + rate) / 2;
        servProv.updateRating(sid, avg);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/change/{uid}")
    public ResponseEntity<?> changePass(@PathVariable String uid, @RequestBody String newPass) {
        userService.changePass(uid, newPass);
        return ResponseEntity.ok("success");
    }
}
