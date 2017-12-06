package ma.oga.microsystemes.myservice.repository;

import ma.oga.microsystemes.myservice.domaine.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
