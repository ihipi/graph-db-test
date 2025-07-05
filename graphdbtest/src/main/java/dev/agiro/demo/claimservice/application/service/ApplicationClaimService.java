package dev.agiro.demo.claimservice.application.service;

import dev.agiro.demo.claimservice.domain.Claim;
import dev.agiro.demo.claimservice.domain.service.ClaimService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
}
