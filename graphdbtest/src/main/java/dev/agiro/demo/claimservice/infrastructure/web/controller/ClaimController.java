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
}
