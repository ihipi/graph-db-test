package dev.agiro.demo.claimservice.application.service;

import dev.agiro.demo.claimservice.domain.Claim;
import dev.agiro.demo.claimservice.domain.service.ClaimService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

@Service // Spring annotation to mark this as a service component
public class ApplicationClaimService {

    private final ClaimService domainClaimService;

    // Constructor injection for the domain service
    public ApplicationClaimService(ClaimService domainClaimService) {
        this.domainClaimService = domainClaimService;
    }

    @Transactional // Ensures the operations are transactional
    public Claim createNewClaim(Claim claim) {
        // Here you could add application-specific logic, e.g., validation,
        // mapping DTOs to domain objects, triggering events, etc.
        return domainClaimService.createClaim(claim);
    }

    @Transactional(readOnly = true) // Read-only transaction for queries
    public Optional<Claim> findClaimById(Long id) {
        return domainClaimService.getClaimById(id);
    }

    @Transactional
    public Claim linkFamilyToClaim(Long claimId, Long familyId) {
        return domainClaimService.linkFamily(claimId, familyId);
    }

    @Transactional
    public Claim linkRegulatorToClaim(Long claimId, Long regulatorId) {
        return domainClaimService.linkRegulator(claimId, regulatorId);
    }

    @Transactional
    public Claim linkDPRuleToClaim(Long claimId, Long dpRuleId) {
        return domainClaimService.linkDPRule(claimId, dpRuleId);
    }

    @Transactional
    public Claim linkSWRuleToClaim(Long claimId, Long swRuleId) {
        return domainClaimService.linkSWRule(claimId, swRuleId);
    }

    @Transactional
    public Claim linkSPRuleToClaim(Long claimId, Long spRuleId) {
        return domainClaimService.linkSPRule(claimId, spRuleId);
    }

    @Transactional
    public Claim linkInvoiceToClaim(Long claimId, Long invoiceId) {
        return domainClaimService.linkInvoice(claimId, invoiceId);
    }

    @Transactional
    public Claim linkNotificationToClaim(Long claimId, Long notificationId) {
        return domainClaimService.linkNotification(claimId, notificationId);
    }

    @Transactional(readOnly = true)
    public List<Claim> searchClaims(LocalDate creationDate, String part, String location) {
        return domainClaimService.searchClaims(creationDate, part, location);
    }

    @Transactional
    public List<Claim> associateClaimsWithEntity(List<Long> claimIds, Long entityId, String entityType) {
        // Application-specific logic like validation or DTO mapping could go here.
        // For example, validating that claimIds is not empty, entityType is one of the allowed values, etc.
        if (claimIds == null || claimIds.isEmpty()) {
            throw new IllegalArgumentException("Claim IDs list cannot be null or empty.");
        }
        if (entityId == null) {
            throw new IllegalArgumentException("Entity ID cannot be null.");
        }
        if (entityType == null || entityType.trim().isEmpty()) {
            throw new IllegalArgumentException("Entity type cannot be null or empty.");
        }
        // Further validation for entityType could be more specific, e.g., checking against an enum or a set of known strings.

        return domainClaimService.associateClaimsWithEntity(claimIds, entityId, entityType);
    }
}
