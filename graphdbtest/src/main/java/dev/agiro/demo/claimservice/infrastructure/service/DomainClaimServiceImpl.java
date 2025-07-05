package dev.agiro.demo.claimservice.infrastructure.service;

import dev.agiro.demo.claimservice.domain.*; // Import all domain entities
import dev.agiro.demo.claimservice.domain.port.*; // Import all repository ports
import dev.agiro.demo.claimservice.domain.service.ClaimService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DomainClaimServiceImpl implements ClaimService {

    private final ClaimRepositoryPort claimRepositoryPort;
    private final FamilyRepositoryPort familyRepositoryPort;
    private final RegulatorRepositoryPort regulatorRepositoryPort;
    private final DPRuleRepositoryPort dpRuleRepositoryPort;
    private final SWRuleRepositoryPort swRuleRepositoryPort;
    private final SPRuleRepositoryPort spRuleRepositoryPort;
    private final InvoiceRepositoryPort invoiceRepositoryPort;
    private final NotificationRepositoryPort notificationRepositoryPort;

    public DomainClaimServiceImpl(ClaimRepositoryPort claimRepositoryPort,
                                FamilyRepositoryPort familyRepositoryPort,
                                RegulatorRepositoryPort regulatorRepositoryPort,
                                DPRuleRepositoryPort dpRuleRepositoryPort,
                                SWRuleRepositoryPort swRuleRepositoryPort,
                                SPRuleRepositoryPort spRuleRepositoryPort,
                                InvoiceRepositoryPort invoiceRepositoryPort,
                                NotificationRepositoryPort notificationRepositoryPort) {
        this.claimRepositoryPort = claimRepositoryPort;
        this.familyRepositoryPort = familyRepositoryPort;
        this.regulatorRepositoryPort = regulatorRepositoryPort;
        this.dpRuleRepositoryPort = dpRuleRepositoryPort;
        this.swRuleRepositoryPort = swRuleRepositoryPort;
        this.spRuleRepositoryPort = spRuleRepositoryPort;
        this.invoiceRepositoryPort = invoiceRepositoryPort;
        this.notificationRepositoryPort = notificationRepositoryPort;
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

    @Override
    @Transactional
    public Claim linkFamily(Long claimId, Long familyId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        Family family = familyRepositoryPort.findById(familyId)
                .orElseThrow(() -> new RuntimeException("Family not found with ID: " + familyId));
        claim.getFamilies().add(family);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim linkRegulator(Long claimId, Long regulatorId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        Regulator regulator = regulatorRepositoryPort.findById(regulatorId)
                .orElseThrow(() -> new RuntimeException("Regulator not found with ID: " + regulatorId));
        claim.getRegulators().add(regulator);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim linkDPRule(Long claimId, Long dpRuleId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        DPRule dpRule = dpRuleRepositoryPort.findById(dpRuleId)
                .orElseThrow(() -> new RuntimeException("DPRule not found with ID: " + dpRuleId));
        claim.getDpRules().add(dpRule);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim linkSWRule(Long claimId, Long swRuleId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        SWRule swRule = swRuleRepositoryPort.findById(swRuleId)
                .orElseThrow(() -> new RuntimeException("SWRule not found with ID: " + swRuleId));
        claim.getSwRules().add(swRule);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim linkSPRule(Long claimId, Long spRuleId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        SPRule spRule = spRuleRepositoryPort.findById(spRuleId)
                .orElseThrow(() -> new RuntimeException("SPRule not found with ID: " + spRuleId));
        claim.getSpRules().add(spRule);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim linkInvoice(Long claimId, Long invoiceId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        Invoice invoice = invoiceRepositoryPort.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + invoiceId));
        claim.getInvoices().add(invoice);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim linkNotification(Long claimId, Long notificationId) {
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        Notification notification = notificationRepositoryPort.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + notificationId));
        claim.getNotifications().add(notification);
        return claimRepositoryPort.save(claim);
    }
}
