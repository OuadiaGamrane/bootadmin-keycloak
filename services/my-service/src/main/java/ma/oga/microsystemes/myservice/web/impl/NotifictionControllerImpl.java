package ma.oga.microsystemes.myservice.web.impl;

import ma.oga.microsystemes.myservice.domaine.Notification;
import ma.oga.microsystemes.myservice.service.NotificationService;
import ma.oga.microsystemes.myservice.web.NotificationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("@userAccessManager.hasRole('NOTIFICATIONS')")
public class NotifictionControllerImpl implements NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Override
    public List<Notification> loadNotifications() {
        return notificationService.loadAllNotifications();
    }
}
