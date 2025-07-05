package com.example.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Regulator extends BaseEntity {

    public Regulator() {
        super();
    }

    public Regulator(String name, String status) {
        super(name, status);
    }
}
