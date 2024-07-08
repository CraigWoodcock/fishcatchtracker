package com.craig.woodcock.fishcatchtracker.model.repository;

import com.craig.woodcock.fishcatchtracker.model.entity.Catch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchRepository extends JpaRepository<Catch, Integer> {
}