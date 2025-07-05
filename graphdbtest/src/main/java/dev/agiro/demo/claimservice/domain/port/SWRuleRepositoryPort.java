package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.SWRule;
import java.util.Optional;
import java.util.List;

public interface SWRuleRepositoryPort {
    SWRule save(SWRule swRule);
    Optional<SWRule> findById(Long id);
    List<SWRule> findAll();
    void deleteById(Long id);
}
