package dev.agiro.demo.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Invoice extends BaseEntity {

    public Invoice() {
        super();
    }

    public Invoice(String name, String status) {
        super(name, status);
    }
}
