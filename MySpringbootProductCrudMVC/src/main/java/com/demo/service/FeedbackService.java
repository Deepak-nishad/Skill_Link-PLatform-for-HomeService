package com.demo.service;

import java.util.List;

import com.demo.model.Feedback;
import com.demo.model.ServiceProvider;

public interface FeedbackService {
    Feedback addFeedback(Feedback feedback);
    List<Feedback> getFeedbackByServiceProvider(ServiceProvider serviceProvider);
}
