package dev.agiro.demo.claimservice.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Node
public class Claim {

    @Id @GeneratedValue
    private Long id;
    private String country;
    private String request;
    private String part;
    private String location;
    private LocalDate creationDate;

    // Relationships to be defined in the next step
    @Relationship(type = "RELATED_TO_FAMILY")
    private Set<Family> families = new HashSet<>();

    @Relationship(type = "HAS_INVOICE")
    private Set<Invoice> invoices = new HashSet<>();

    @Relationship(type = "GOVERNED_BY_DP_RULE")
    private Set<DPRule> dpRules = new HashSet<>();

    @Relationship(type = "GOVERNED_BY_SW_RULE")
    private Set<SWRule> swRules = new HashSet<>();

    @Relationship(type = "GOVERNED_BY_SP_RULE")
    private Set<SPRule> spRules = new HashSet<>();

    @Relationship(type = "REGULATED_BY")
    private Set<Regulator> regulators = new HashSet<>();

    @Relationship(type = "HAS_NOTIFICATION")
    private Set<Notification> notifications = new HashSet<>();


    public Claim() {
    }

    public Claim(String country, String request, String part, String location, LocalDate creationDate) {
        this.country = country;
        this.request = request;
        this.part = part;
        this.location = location;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Set<Family> families) {
        this.families = families;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<DPRule> getDpRules() {
        return dpRules;
    }

    public void setDpRules(Set<DPRule> dpRules) {
        this.dpRules = dpRules;
    }

    public Set<SWRule> getSwRules() {
        return swRules;
    }

    public void setSwRules(Set<SWRule> swRules) {
        this.swRules = swRules;
    }

    public Set<SPRule> getSpRules() {
        return spRules;
    }

    public void setSpRules(Set<SPRule> spRules) {
        this.spRules = spRules;
    }

    public Set<Regulator> getRegulators() {
        return regulators;
    }

    public void setRegulators(Set<Regulator> regulators) {
        this.regulators = regulators;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }
}
