package dev.agiro.demo.claimservice.domain.port;

import dev.agiro.demo.claimservice.domain.Notification;
import java.util.Optional;
import java.util.List;

public interface NotificationRepositoryPort {
    Notification save(Notification notification);
    Optional<Notification> findById(Long id);
    List<Notification> findAll();
    void deleteById(Long id);
}
