package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.SPRule;
import dev.agiro.demo.claimservice.domain.port.SPRuleRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SPRuleNeo4jRepository extends Neo4jRepository<SPRule, Long>, SPRuleRepositoryPort {
}
