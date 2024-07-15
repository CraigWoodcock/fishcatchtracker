package com.craig.woodcock.fishcatchtracker.model.service;

import com.craig.woodcock.fishcatchtracker.model.entity.Angler;
import com.craig.woodcock.fishcatchtracker.model.repository.AnglerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnglerService {
    private final AnglerRepository anglerRepository;

    @Autowired
    public AnglerService(AnglerRepository anglerRepository) {
        this.anglerRepository = anglerRepository;
    }

    public Angler findOrCreateByName(String name) {
        return anglerRepository.findByName(name).orElseGet(() -> {
            Angler angler = new Angler();
            angler.setName(name);
            return anglerRepository.save(angler);
        });
    }

}
