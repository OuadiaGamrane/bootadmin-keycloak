package ma.oga.microsystemes.myservice.service.impl;

import ma.oga.microsystemes.myservice.domaine.Notification;
import ma.oga.microsystemes.myservice.repository.NotificationRepository;
import ma.oga.microsystemes.myservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> loadAllNotifications() {
        return notificationRepository.findAll();
    }
}
