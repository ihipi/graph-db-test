package dev.agiro.demo.claimservice.infrastructure.repository;

import dev.agiro.demo.claimservice.domain.Invoice;
import dev.agiro.demo.claimservice.domain.port.InvoiceRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceNeo4jRepository extends Neo4jRepository<Invoice, Long>, InvoiceRepositoryPort {
}
