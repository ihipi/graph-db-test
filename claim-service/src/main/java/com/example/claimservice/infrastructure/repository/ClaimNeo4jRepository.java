package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.Claim;
import com.example.claimservice.domain.port.ClaimRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimNeo4jRepository extends Neo4jRepository<Claim, Long>, ClaimRepositoryPort {
    // Spring Data Neo4j will automatically provide implementations for methods like:
    // Claim save(Claim claim);
    // Optional<Claim> findById(Long id);
    // List<Claim> findAll();
    // void deleteById(Long id);
    // Custom query methods can be added here if needed.
}
