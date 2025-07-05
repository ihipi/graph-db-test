package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.Notification;
import dev.agiro.demo.claimservice.domain.port.NotificationRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationNeo4jRepository extends Neo4jRepository<Notification, Long>, NotificationRepositoryPort {
    // Spring Data Neo4j will automatically implement the methods defined in NotificationRepositoryPort
    // and Neo4jRepository. Additional custom query methods can be added here if needed.
}
