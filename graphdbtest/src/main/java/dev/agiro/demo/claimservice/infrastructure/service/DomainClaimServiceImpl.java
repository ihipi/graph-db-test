package dev.agiro.demo.claimservice.infrastructure.service;

import dev.agiro.demo.claimservice.domain.*; // Import all domain entities
import dev.agiro.demo.claimservice.domain.port.*; // Import all repository ports
import dev.agiro.demo.claimservice.domain.service.ClaimService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public List<Claim> searchClaims(LocalDate creationDate, String part, String location) {
        // Basic validation or logging could be added here if needed
        return claimRepositoryPort.searchClaims(creationDate, part, location);
    }

    @Override
    @Transactional
    public List<Claim> associateClaimsWithEntity(List<Long> claimIds, Long entityId, String entityType) {
        List<Claim> updatedClaims = new java.util.ArrayList<>();

        // Fetch the target entity first
        Object targetEntity = null;
        switch (entityType.toUpperCase()) {
            case "FAMILY":
                targetEntity = familyRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("Family not found with ID: " + entityId));
                break;
            case "REGULATOR":
                targetEntity = regulatorRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("Regulator not found with ID: " + entityId));
                break;
            case "DPRULE":
                targetEntity = dpRuleRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("DPRule not found with ID: " + entityId));
                break;
            case "SWRULE":
                targetEntity = swRuleRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("SWRule not found with ID: " + entityId));
                break;
            case "SPRULE":
                targetEntity = spRuleRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("SPRule not found with ID: " + entityId));
                break;
            case "INVOICE":
                targetEntity = invoiceRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + entityId));
                break;
            case "NOTIFICATION":
                targetEntity = notificationRepositoryPort.findById(entityId)
                        .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + entityId));
                break;
            default:
                throw new IllegalArgumentException("Invalid entity type: " + entityType);
        }

        for (Long claimId : claimIds) {
            Claim claim = claimRepositoryPort.findById(claimId)
                    .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId + " during batch association."));

            switch (entityType.toUpperCase()) {
                case "FAMILY":
                    claim.getFamilies().add((Family) targetEntity);
                    break;
                case "REGULATOR":
                    claim.getRegulators().add((Regulator) targetEntity);
                    break;
                case "DPRULE":
                    claim.getDpRules().add((DPRule) targetEntity);
                    break;
                case "SWRULE":
                    claim.getSwRules().add((SWRule) targetEntity);
                    break;
                case "SPRULE":
                    claim.getSpRules().add((SPRule) targetEntity);
                    break;
                case "INVOICE":
                    claim.getInvoices().add((Invoice) targetEntity);
                    break;
                case "NOTIFICATION":
                    claim.getNotifications().add((Notification) targetEntity);
                    break;
            }
            updatedClaims.add(claimRepositoryPort.save(claim));
        }
        return updatedClaims;
    }

    // Implementations for createAndLink methods
    @Override
    @Transactional
    public Claim createAndLinkFamily(Long claimId, Family family) {
        Family newFamily = familyRepositoryPort.save(family);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getFamilies().add(newFamily);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim createAndLinkRegulator(Long claimId, Regulator regulator) {
        Regulator newRegulator = regulatorRepositoryPort.save(regulator);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getRegulators().add(newRegulator);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim createAndLinkDPRule(Long claimId, DPRule dpRule) {
        DPRule newDPRule = dpRuleRepositoryPort.save(dpRule);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getDpRules().add(newDPRule);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim createAndLinkSWRule(Long claimId, SWRule swRule) {
        SWRule newSWRule = swRuleRepositoryPort.save(swRule);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getSwRules().add(newSWRule);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim createAndLinkSPRule(Long claimId, SPRule spRule) {
        SPRule newSPRule = spRuleRepositoryPort.save(spRule);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getSpRules().add(newSPRule);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim createAndLinkInvoice(Long claimId, Invoice invoice) {
        Invoice newInvoice = invoiceRepositoryPort.save(invoice);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getInvoices().add(newInvoice);
        return claimRepositoryPort.save(claim);
    }

    @Override
    @Transactional
    public Claim createAndLinkNotification(Long claimId, Notification notification) {
        Notification newNotification = notificationRepositoryPort.save(notification);
        Claim claim = claimRepositoryPort.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found with ID: " + claimId));
        claim.getNotifications().add(newNotification);
        return claimRepositoryPort.save(claim);
    }
}
