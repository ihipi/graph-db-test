package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.DPRule;
import java.util.Optional;
import java.util.List;

public interface DPRuleRepositoryPort {
    DPRule save(DPRule dpRule);
    Optional<DPRule> findById(Long id);
    List<DPRule> findAll();
    void deleteById(Long id);
}
