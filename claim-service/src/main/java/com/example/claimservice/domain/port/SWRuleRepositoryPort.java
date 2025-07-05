package com.example.claimservice.domain.port;

import com.example.claimservice.domain.SWRule;
import java.util.Optional;
import java.util.List;

public interface SWRuleRepositoryPort {
    SWRule save(SWRule swRule);
    Optional<SWRule> findById(Long id);
    List<SWRule> findAll();
    void deleteById(Long id);
}
