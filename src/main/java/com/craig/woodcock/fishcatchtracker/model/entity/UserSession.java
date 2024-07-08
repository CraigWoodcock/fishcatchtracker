package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_sessions")
public class UserSession {
    @EmbeddedId
    private UserSessionId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("sessionId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    public UserSessionId getId() {
        return id;
    }

    public void setId(UserSessionId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}