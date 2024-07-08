package com.craig.woodcock.fishcatchtracker.model.repository;

import com.craig.woodcock.fishcatchtracker.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}