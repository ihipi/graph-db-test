package dev.agiro.demo.claimservice.infrastructure.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateRelatedNodeRequestDto {

    @NotEmpty(message = "Name cannot be empty.")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters.")
    private String name;

    @NotEmpty(message = "Status cannot be empty.")
    @Size(min = 1, max = 100, message = "Status must be between 1 and 100 characters.")
    private String status;

    // Default constructor
    public CreateRelatedNodeRequestDto() {
    }

    // Constructor with fields
    public CreateRelatedNodeRequestDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
