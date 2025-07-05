package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.SPRule;
import java.util.Optional;
import java.util.List;

public interface SPRuleRepositoryPort {
    SPRule save(SPRule spRule);
    Optional<SPRule> findById(Long id);
    List<SPRule> findAll();
    void deleteById(Long id);
}
