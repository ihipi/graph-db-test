package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.Regulator;
import com.example.claimservice.domain.port.RegulatorRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulatorNeo4jRepository extends Neo4jRepository<Regulator, Long>, RegulatorRepositoryPort {
}
