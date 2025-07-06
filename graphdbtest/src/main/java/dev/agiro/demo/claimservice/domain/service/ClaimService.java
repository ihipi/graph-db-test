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

    // Methods to create a new related node and link it to a claim
    Claim createAndLinkFamily(Long claimId, Family family);
    Claim createAndLinkRegulator(Long claimId, Regulator regulator);
    Claim createAndLinkDPRule(Long claimId, DPRule dpRule);
    Claim createAndLinkSWRule(Long claimId, SWRule swRule);
    Claim createAndLinkSPRule(Long claimId, SPRule spRule);
    Claim createAndLinkInvoice(Long claimId, Invoice invoice);
    Claim createAndLinkNotification(Long claimId, Notification notification);
}
