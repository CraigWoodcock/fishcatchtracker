package com.craig.woodcock.fishcatchtracker.controller;

import com.craig.woodcock.fishcatchtracker.model.entity.Angler;
import com.craig.woodcock.fishcatchtracker.model.entity.Session;
import com.craig.woodcock.fishcatchtracker.model.entity.User;
import com.craig.woodcock.fishcatchtracker.model.service.CustomUserDetails;
import com.craig.woodcock.fishcatchtracker.model.service.SessionService;
import com.craig.woodcock.fishcatchtracker.model.service.CustomUserDetailsService;
import com.craig.woodcock.fishcatchtracker.model.service.AnglerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class SessionController {

    private static final Logger logger = Logger.getLogger(SessionController.class.getName());
    private final SessionService sessionService;
    private final CustomUserDetailsService customUserDetailsService;
    private final AnglerService anglerService;

    @Autowired
    public SessionController(SessionService sessionService, CustomUserDetailsService customUserDetailsService, AnglerService anglerService) {
        this.sessionService = sessionService;
        this.customUserDetailsService = customUserDetailsService;
        this.anglerService = anglerService;
    }

    @GetMapping("/sessions")
    public String listSessions(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        Integer userId = customUserDetails.getUser().getId();
        List<Session> sessions = sessionService.getSessionsByUserIds(userId);

        logger.info("User ID: " + userId);
        logger.info("Retrieved sessions: " + sessions.size());
        if (sessions.isEmpty()) {
            model.addAttribute("message", "No sessions found for the current user.");
        } else {
            model.addAttribute("sessions", sessions);
        }

        return "session-details";
    }

    @PostMapping("/sessions/add")
    public String addSession(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                             @RequestParam String venue,
                             @RequestParam String date,
                             @RequestParam String anglers) {
        User user = customUserDetails.getUser();
        Session session = new Session();
        session.setUser(user);
        session.setVenue(venue);
        session.setDate(LocalDate.parse(date));
        session.setCreatedAt(Timestamp.from(Instant.now()));

        // Split the comma-separated anglers and add them to the session
        Set<Angler> anglersList = new HashSet<>();
        for (String a: anglers.split(",")) {
            anglerService.findOrCreateByName(a);
        }
        session.setAnglers(anglersList);

        // Save the session
        sessionService.saveSession(session);

        return "redirect:/sessions";
    }

    @PostMapping("/sessions/delete/{id}")
    public String deleteSession(@PathVariable Integer id, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        User user = customUserDetails.getUser();
        logger.info("Attempting to delete session ID: " + id + " for user ID: " + user.getId());

        // Fetch the session to ensure it belongs to the user
        Session session = sessionService.getSessionById(id);
        logger.info("Fetched session: " + session);

        if (session != null && session.getUser().equals(user)) {
            sessionService.deleteSession(id);
            logger.info("Deleted session ID: " + id);
        } else {
            logger.warning("Failed to delete session ID: " + id + " - Session not found or does not belong to user.");
            return "redirect:/sessions?error=notfound";
        }

        return "redirect:/sessions";
    }
}
