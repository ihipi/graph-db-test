package com.example.claimservice.infrastructure.service;

import com.example.claimservice.domain.Claim;
import com.example.claimservice.domain.port.ClaimRepositoryPort;
// Import other repository ports as needed for more complex operations
import com.example.claimservice.domain.service.ClaimService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service // This service will be implementing a domain interface, but it's part of infrastructure
         // as it depends on specific data access mechanisms (Neo4j repositories).
public class DomainClaimServiceImpl implements ClaimService {

    private final ClaimRepositoryPort claimRepositoryPort;
    // Inject other repository ports here if needed for linking entities, e.g.:
    // private final FamilyRepositoryPort familyRepositoryPort;
    // private final InvoiceRepositoryPort invoiceRepositoryPort;

    public DomainClaimServiceImpl(ClaimRepositoryPort claimRepositoryPort) {
        this.claimRepositoryPort = claimRepositoryPort;
    }

    @Override
    @Transactional
    public Claim createClaim(Claim claim) {
        // Domain logic related to claim creation can go here.
        // For now, it's a direct save.
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Claim> getClaimById(Long id) {
        return claimRepositoryPort.findById(id);
    }

    // Implement other methods from ClaimService interface here
    // For example:
    // @Override
    // @Transactional
    // public Claim addFamilyToClaim(Long claimId, Family family) {
    //     Claim claim = claimRepositoryPort.findById(claimId)
    //          .orElseThrow(() -> new RuntimeException("Claim not found"));
    //     // Assuming Family is already saved or managed appropriately
    //     claim.getFamilies().add(family);
    //     return claimRepositoryPort.save(claim);
    // }
}
