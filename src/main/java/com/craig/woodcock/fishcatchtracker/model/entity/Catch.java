package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalTime;

@Entity
@Table(name = "catches")
public class Catch {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "angler_id", nullable = false)
    private Angler angler;

    @NotNull
    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Size(max = 100)
    @NotNull
    @Column(name = "lake", nullable = false, length = 100)
    private String lake;

    @NotNull
    @Column(name = "peg_no", nullable = false)
    private Integer pegNo;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Size(max = 255)
    @Column(name = "photo_url")
    private String photoUrl;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLake() {
        return lake;
    }

    public void setLake(String lake) {
        this.lake = lake;
    }

    public Integer getPegNo() {
        return pegNo;
    }

    public void setPegNo(Integer pegNo) {
        this.pegNo = pegNo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}