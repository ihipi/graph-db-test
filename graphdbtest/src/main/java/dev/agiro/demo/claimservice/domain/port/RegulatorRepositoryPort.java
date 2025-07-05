package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.Regulator;
import java.util.Optional;
import java.util.List;

public interface RegulatorRepositoryPort {
    Regulator save(Regulator regulator);
    Optional<Regulator> findById(Long id);
    List<Regulator> findAll();
    void deleteById(Long id);
}
