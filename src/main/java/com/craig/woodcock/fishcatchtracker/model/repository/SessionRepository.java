package com.craig.woodcock.fishcatchtracker.model.repository;

import com.craig.woodcock.fishcatchtracker.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    @Query("SELECT s FROM Session s WHERE s.user.id = :userId")
    List<Session> findSessionsByUserIds(@Param("userId") Integer userId);
}
