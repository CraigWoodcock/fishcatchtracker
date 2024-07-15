package com.craig.woodcock.fishcatchtracker.model.service;

import com.craig.woodcock.fishcatchtracker.model.entity.Session;
import com.craig.woodcock.fishcatchtracker.model.entity.User;
import com.craig.woodcock.fishcatchtracker.model.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getSessionsByUserIds(Integer userId) {
        return sessionRepository.findSessionsByUserIds(userId);
    }

    public void saveSession(Session session) {
        sessionRepository.save(session);
    }

    public void deleteSession(Integer sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    public Session getSessionById(Integer sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }
}
