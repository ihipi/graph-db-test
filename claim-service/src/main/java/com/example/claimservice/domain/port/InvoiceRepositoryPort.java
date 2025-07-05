package com.example.claimservice.domain.port;

import com.example.claimservice.domain.Invoice;
import java.util.Optional;
import java.util.List;

public interface InvoiceRepositoryPort {
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(Long id);
    List<Invoice> findAll();
    void deleteById(Long id);
}
