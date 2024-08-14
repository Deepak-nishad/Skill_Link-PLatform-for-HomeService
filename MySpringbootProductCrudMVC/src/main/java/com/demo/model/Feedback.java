package com.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "serviceproviderid", nullable = false) // Correctly mapping the foreign key
    private ServiceProvider serviceProvider; // Changing the type to ServiceProvider


    @Column(name = "rating", nullable = false)
    private int rating;

    public Feedback() {}

    public Feedback(User user, ServiceProvider serviceProvider, int rating) {
        this.user = user;
        this.serviceProvider = serviceProvider;
        this.rating = rating;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
