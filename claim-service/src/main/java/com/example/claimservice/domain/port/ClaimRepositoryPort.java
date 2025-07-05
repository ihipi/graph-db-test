package com.example.claimservice.domain.port;

import com.example.claimservice.domain.Claim;
import java.util.Optional;
import java.util.List;

public interface ClaimRepositoryPort {
    Claim save(Claim claim);
    Optional<Claim> findById(Long id);
    List<Claim> findAll();
    void deleteById(Long id);
}
