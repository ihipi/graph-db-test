package com.example.claimservice.domain.port;

import com.example.claimservice.domain.Family;
import java.util.Optional;
import java.util.List;

public interface FamilyRepositoryPort {
    Family save(Family family);
    Optional<Family> findById(Long id);
    List<Family> findAll();
    void deleteById(Long id);
}
