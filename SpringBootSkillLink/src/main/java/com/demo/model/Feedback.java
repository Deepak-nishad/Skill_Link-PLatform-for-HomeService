package com.demo.model;

import javax.persistence.*;

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
    @JoinColumn(name = "serviceproviderid", nullable = false)
    private ServiceProvider serviceProvider;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment", length = 1000)
    private String comment;

    public Feedback() {}

    public Feedback(User user, ServiceProvider serviceProvider, int rating, String comment) {
        this.user = user;
        this.serviceProvider = serviceProvider;
        this.rating = rating;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
