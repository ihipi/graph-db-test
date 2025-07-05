package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.SWRule;
import com.example.claimservice.domain.port.SWRuleRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWRuleNeo4jRepository extends Neo4jRepository<SWRule, Long>, SWRuleRepositoryPort {
}
