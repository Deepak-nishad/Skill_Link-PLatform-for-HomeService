package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Feedback;
import com.demo.model.ServiceProvider;
import com.demo.model.User;
import com.demo.service.FeedbackService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Endpoint to add feedback
    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@Validated @RequestBody Feedback feedback) {
        try {
        	System.out.println("code chla feedback waala"+feedback);
            Feedback savedFeedback = feedbackService.addFeedback(feedback);
            return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to get feedback by service provider
    @GetMapping("/serviceProvider/{serviceProviderId}")
    public ResponseEntity<List<Feedback>> getFeedbackByServiceProvider(@PathVariable("serviceProviderId") int serviceProviderId) {
        try {
            ServiceProvider serviceProvider = new ServiceProvider(serviceProviderId); // Assuming ServiceProvider entity is correctly fetched.
            List<Feedback> feedbackList = feedbackService.getFeedbackByServiceProvider(serviceProvider);
            if (feedbackList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(feedbackList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Optional: Endpoint to get all feedbacks given by a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Feedback>> getFeedbacksGivenByUser(@PathVariable("userId") int userId) {
        try {
            User user = new User(userId); // Assuming User entity is correctly fetched.
            Set<Feedback> feedbackList = user.getFeedbacksGiven();
            if (feedbackList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new ArrayList<>(feedbackList), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

