package com.craig.woodcock.fishcatchtracker.model.repository;

import com.craig.woodcock.fishcatchtracker.model.entity.UserSession;
import com.craig.woodcock.fishcatchtracker.model.entity.UserSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, UserSessionId> {
}