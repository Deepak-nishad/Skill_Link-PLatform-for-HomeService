package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FeedbackDao;
import com.demo.model.Feedback;
import com.demo.model.ServiceProvider;

import com.demo.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public Feedback addFeedback(Feedback feedback) {
        return feedbackDao.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByServiceProvider(ServiceProvider serviceProvider) {
        return feedbackDao.findByServiceProvider(serviceProvider);
    }
}
