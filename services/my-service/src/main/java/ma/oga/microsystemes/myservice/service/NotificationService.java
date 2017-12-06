package ma.oga.microsystemes.myservice.service;

import ma.oga.microsystemes.myservice.domaine.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> loadAllNotifications();
}
