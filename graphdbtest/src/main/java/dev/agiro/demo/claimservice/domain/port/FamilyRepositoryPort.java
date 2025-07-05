package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.Family;
import java.util.Optional;
import java.util.List;

public interface FamilyRepositoryPort {
    Family save(Family family);
    Optional<Family> findById(Long id);
    List<Family> findAll();
    void deleteById(Long id);
}
