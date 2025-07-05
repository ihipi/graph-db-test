package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.Regulator;
import dev.agiro.demo.claimservice.domain.port.RegulatorRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulatorNeo4jRepository extends Neo4jRepository<Regulator, Long>, RegulatorRepositoryPort {
}
