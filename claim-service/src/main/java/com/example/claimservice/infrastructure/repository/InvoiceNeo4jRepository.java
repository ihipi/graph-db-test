package com.example.claimservice.infrastructure.repository;

import com.example.claimservice.domain.Invoice;
import com.example.claimservice.domain.port.InvoiceRepositoryPort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceNeo4jRepository extends Neo4jRepository<Invoice, Long>, InvoiceRepositoryPort {
}
