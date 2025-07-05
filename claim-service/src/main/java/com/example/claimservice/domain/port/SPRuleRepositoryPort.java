package com.example.claimservice.domain.port;

import com.example.claimservice.domain.SPRule;
import java.util.Optional;
import java.util.List;

public interface SPRuleRepositoryPort {
    SPRule save(SPRule spRule);
    Optional<SPRule> findById(Long id);
    List<SPRule> findAll();
    void deleteById(Long id);
}
