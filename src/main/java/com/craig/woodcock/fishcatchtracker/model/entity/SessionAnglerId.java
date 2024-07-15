package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SessionAnglerId implements Serializable {
    private static final long serialVersionUID = 3436254981269058709L;
    @NotNull
    @Column(name = "session_id", nullable = false)
    private Integer sessionId;

    @NotNull
    @Column(name = "angler_id", nullable = false)
    private Integer anglerId;

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
        SessionAnglerId entity = (SessionAnglerId) o;
        return Objects.equals(this.sessionId, entity.sessionId) &&
                Objects.equals(this.anglerId, entity.anglerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, anglerId);
    }

}