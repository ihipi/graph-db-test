package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.SWRule;
import dev.agiro.demo.claimservice.domain.port.SWRuleRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWRuleNeo4jRepository extends Neo4jRepository<SWRule, Long>, SWRuleRepositoryPort {
}
