package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "session_anglers")
public class SessionAngler {
    @EmbeddedId
    private SessionAnglerId id;

    @MapsId("sessionId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @MapsId("anglerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "angler_id", nullable = false)
    private Angler angler;

    public SessionAnglerId getId() {
        return id;
    }

    public void setId(SessionAnglerId id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Angler getAngler() {
        return angler;
    }

    public void setAngler(Angler angler) {
        this.angler = angler;
    }

}