package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.Invoice;
import java.util.Optional;
import java.util.List;

public interface InvoiceRepositoryPort {
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(Long id);
    List<Invoice> findAll();
    void deleteById(Long id);
}
