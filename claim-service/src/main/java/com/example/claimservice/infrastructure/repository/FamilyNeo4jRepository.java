package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.Family;
import com.example.claimservice.domain.port.FamilyRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyNeo4jRepository extends Neo4jRepository<Family, Long>, FamilyRepositoryPort {
}
