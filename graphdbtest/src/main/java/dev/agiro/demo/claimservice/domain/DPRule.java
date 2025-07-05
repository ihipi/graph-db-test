package dev.agiro.demo.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("DP_Rule") // Explicitly naming the node label
public class DPRule extends BaseEntity {

    public DPRule() {
        super();
    }

    public DPRule(String name, String status) {
        super(name, status);
    }
}
