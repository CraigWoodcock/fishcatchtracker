package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserSessionId implements Serializable {
    private static final long serialVersionUID = -9222153979873663860L;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @NotNull
    @Column(name = "session_id", nullable = false)
    private Integer sessionId;

    @NotNull
    @Column(name = "angler_id", nullable = false)
    private Integer anglerId;  // Added anglerId to the composite key

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getAnglerId() {
        return anglerId;
    }

    public void setAnglerId(Integer anglerId) {
        this.anglerId = anglerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserSessionId entity = (UserSessionId) o;
        return Objects.equals(this.sessionId, entity.sessionId) &&
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.anglerId, entity.anglerId); // Added anglerId to equals method
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, userId, anglerId); // Added anglerId to hashCode method
    }
}
