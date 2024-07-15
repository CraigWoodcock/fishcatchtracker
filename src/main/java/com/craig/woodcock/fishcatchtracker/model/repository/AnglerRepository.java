package com.craig.woodcock.fishcatchtracker.model.repository;

import com.craig.woodcock.fishcatchtracker.model.entity.Angler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnglerRepository extends JpaRepository<Angler, Integer> {
    Optional<Angler> findByName(String name);
}