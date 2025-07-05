package dev.agiro.demo.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("SP_Rule") // Explicitly naming the node label
public class SPRule extends BaseEntity {

    public SPRule() {
        super();
    }

    public SPRule(String name, String status) {
        super(name, status);
    }
}
