package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.DPRule;
import dev.agiro.demo.claimservice.domain.port.DPRuleRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DPRuleNeo4jRepository extends Neo4jRepository<DPRule, Long>, DPRuleRepositoryPort {
}
