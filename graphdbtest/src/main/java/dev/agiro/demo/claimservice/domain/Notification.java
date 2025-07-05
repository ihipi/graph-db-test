package dev.agiro.demo.claimservice.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Notification extends BaseEntity {

    public Notification() {
        super();
    }

    public Notification(String name, String status) {
        super(name, status);
    }
}
