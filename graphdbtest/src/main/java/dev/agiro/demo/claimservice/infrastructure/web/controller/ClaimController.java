package dev.agiro.demo.claimservice.infrastructure.web.controller;

import dev.agiro.demo.claimservice.application.service.ApplicationClaimService;
import dev.agiro.demo.claimservice.domain.Claim;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat; // For date parsing

// Keep existing imports from previous steps
import dev.agiro.demo.claimservice.domain.Claim;
import dev.agiro.demo.claimservice.application.service.ApplicationClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import dev.agiro.demo.claimservice.infrastructure.web.dto.BatchAssociationRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

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

    @PostMapping("/{claimId}/family/{familyId}")
    public ResponseEntity<Claim> linkFamilyToClaim(@PathVariable Long claimId, @PathVariable Long familyId) {
        try {
            Claim updatedClaim = applicationClaimService.linkFamilyToClaim(claimId, familyId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) { // Consider more specific exception handling
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Or BAD_REQUEST if IDs are invalid
        }
    }

    @PostMapping("/{claimId}/regulator/{regulatorId}")
    public ResponseEntity<Claim> linkRegulatorToClaim(@PathVariable Long claimId, @PathVariable Long regulatorId) {
        try {
            Claim updatedClaim = applicationClaimService.linkRegulatorToClaim(claimId, regulatorId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{claimId}/dprule/{dpRuleId}")
    public ResponseEntity<Claim> linkDPRuleToClaim(@PathVariable Long claimId, @PathVariable Long dpRuleId) {
        try {
            Claim updatedClaim = applicationClaimService.linkDPRuleToClaim(claimId, dpRuleId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{claimId}/swrule/{swRuleId}")
    public ResponseEntity<Claim> linkSWRuleToClaim(@PathVariable Long claimId, @PathVariable Long swRuleId) {
        try {
            Claim updatedClaim = applicationClaimService.linkSWRuleToClaim(claimId, swRuleId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{claimId}/sprule/{spRuleId}")
    public ResponseEntity<Claim> linkSPRuleToClaim(@PathVariable Long claimId, @PathVariable Long spRuleId) {
        try {
            Claim updatedClaim = applicationClaimService.linkSPRuleToClaim(claimId, spRuleId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{claimId}/invoice/{invoiceId}")
    public ResponseEntity<Claim> linkInvoiceToClaim(@PathVariable Long claimId, @PathVariable Long invoiceId) {
        try {
            Claim updatedClaim = applicationClaimService.linkInvoiceToClaim(claimId, invoiceId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{claimId}/notification/{notificationId}")
    public ResponseEntity<Claim> linkNotificationToClaim(@PathVariable Long claimId, @PathVariable Long notificationId) {
        try {
            Claim updatedClaim = applicationClaimService.linkNotificationToClaim(claimId, notificationId);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Claim>> searchClaims(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDate,
            @RequestParam(required = false) String part,
            @RequestParam(required = false) String location) {
        try {
            List<Claim> claims = applicationClaimService.searchClaims(creationDate, part, location);
            if (claims.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(claims, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception e
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/associate-batch")
    public ResponseEntity<List<Claim>> batchAssociateClaimsWithEntity(@Valid @RequestBody BatchAssociationRequest request) {
        try {
            List<Claim> updatedClaims = applicationClaimService.associateClaimsWithEntity(
                    request.getClaimIds(),
                    request.getEntityId(),
                    request.getEntityType());
            return new ResponseEntity<>(updatedClaims, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Log e.getMessage() or return it in a structured error response
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Or HttpStatus.UNPROCESSABLE_ENTITY
        } catch (RuntimeException e) { // Catch other runtime exceptions like entity not found
            // Log e.getMessage()
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Or more specific error based on e
        } catch (Exception e) {
            // Log e.getMessage()
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
