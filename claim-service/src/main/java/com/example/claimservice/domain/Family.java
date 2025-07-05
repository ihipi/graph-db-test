package com.example.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Family extends BaseEntity {

    public Family() {
        super();
    }

    public Family(String name, String status) {
        super(name, status);
    }
}
