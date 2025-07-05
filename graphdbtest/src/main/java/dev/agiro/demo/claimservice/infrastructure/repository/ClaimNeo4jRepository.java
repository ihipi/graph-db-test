package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.Claim;
import dev.agiro.demo.claimservice.domain.port.ClaimRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClaimNeo4jRepository extends Neo4jRepository<Claim, Long>, ClaimRepositoryPort {
    // Spring Data Neo4j will automatically provide implementations for methods like:
    // Claim save(Claim claim);
    // Optional<Claim> findById(Long id);
    // List<Claim> findAll();
    // void deleteById(Long id);
    // Custom query methods can be added here if needed.

    @Query("MATCH (c:Claim) " +
           "WHERE ($creationDate IS NULL OR c.creationDate = $creationDate) " +
           "AND ($part IS NULL OR toLower(c.part) CONTAINS toLower($part)) " +
           "AND ($location IS NULL OR toLower(c.location) CONTAINS toLower($location)) " +
           "RETURN c")
    @Override // This must override the method in ClaimRepositoryPort
    List<Claim> searchClaims(@Param("creationDate") LocalDate creationDate,
                             @Param("part") String part,
                             @Param("location") String location);
}
