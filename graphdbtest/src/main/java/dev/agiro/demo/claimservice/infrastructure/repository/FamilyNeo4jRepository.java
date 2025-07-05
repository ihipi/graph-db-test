package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.Family;
import dev.agiro.demo.claimservice.domain.port.FamilyRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyNeo4jRepository extends Neo4jRepository<Family, Long>, FamilyRepositoryPort {
}
