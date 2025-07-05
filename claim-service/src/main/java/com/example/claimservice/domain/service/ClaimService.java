package com.example.claimservice.domain.service;

import com.example.claimservice.domain.Claim;
import java.util.Optional;

public interface ClaimService {

    Claim createClaim(Claim claim);

    Optional<Claim> getClaimById(Long id);

    // Add more domain-specific methods here as needed, for example:
    // Claim addFamilyToClaim(Long claimId, Family family);
    // Claim addInvoiceToClaim(Long claimId, Invoice invoice);
    // Claim addRuleToClaim(Long claimId, BaseRule rule); // Assuming a common interface/superclass for rules
    // Claim addRegulatorToClaim(Long claimId, Regulator regulator);
    // Claim updateClaimStatus(Long claimId, String status);
}
