package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.SPRule;
import com.example.claimservice.domain.port.SPRuleRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SPRuleNeo4jRepository extends Neo4jRepository<SPRule, Long>, SPRuleRepositoryPort {
}
