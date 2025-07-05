package dev.agiro.demo.claimservice.infrastructure.web.controller;

import dev.agiro.demo.claimservice.application.service.ApplicationClaimService;
import dev.agiro.demo.claimservice.domain.Claim;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ApplicationClaimService applicationClaimService;

    public ClaimController(ApplicationClaimService applicationClaimService) {
        this.applicationClaimService = applicationClaimService;
    }

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim createdClaim = applicationClaimService.createNewClaim(claim);
        return new ResponseEntity<>(createdClaim, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Optional<Claim> claimOptional = applicationClaimService.findClaimById(id);
        return claimOptional.map(claim -> new ResponseEntity<>(claim, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
