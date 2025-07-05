package com.example.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("SW_Rule") // Explicitly naming the node label
public class SWRule extends BaseEntity {

    public SWRule() {
        super();
    }

    public SWRule(String name, String status) {
        super(name, status);
    }
}
