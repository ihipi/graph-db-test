package dev.agiro.demo.claimservice.domain.service;

import dev.agiro.demo.claimservice.domain.Claim;
import java.util.Optional;

public interface ClaimService {

    Claim createClaim(Claim claim);

    Optional<Claim> getClaimById(Long id);

    Claim linkFamily(Long claimId, Long familyId);
    Claim linkRegulator(Long claimId, Long regulatorId);
    Claim linkDPRule(Long claimId, Long dpRuleId);
    Claim linkSWRule(Long claimId, Long swRuleId);
    Claim linkSPRule(Long claimId, Long spRuleId);
    Claim linkInvoice(Long claimId, Long invoiceId);
    Claim linkNotification(Long claimId, Long notificationId);

    List<Claim> searchClaims(LocalDate creationDate, String part, String location);

    List<Claim> associateClaimsWithEntity(List<Long> claimIds, Long entityId, String entityType);
}
