package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String venue;
    private LocalDate date;
    private Timestamp createdAt;

    @ManyToMany
    @JoinTable(
            name = "session_anglers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "angler_id")
    )
    private Set<Angler> anglers;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Angler> getAnglers() {
        return anglers;
    }

    public void setAnglers(Set<Angler> anglers) {
        this.anglers = anglers;
    }
}
