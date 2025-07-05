package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.DPRule;
import com.example.claimservice.domain.port.DPRuleRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DPRuleNeo4jRepository extends Neo4jRepository<DPRule, Long>, DPRuleRepositoryPort {
}
