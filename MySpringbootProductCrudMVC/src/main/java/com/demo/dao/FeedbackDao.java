package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Feedback;
import com.demo.model.ServiceProvider;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByServiceProvider(ServiceProvider serviceProvider);
}
