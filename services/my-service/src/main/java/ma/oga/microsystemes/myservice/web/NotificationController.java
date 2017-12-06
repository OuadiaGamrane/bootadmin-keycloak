package ma.oga.microsystemes.myservice.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.oga.microsystemes.myservice.domaine.Notification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.Callable;

@RequestMapping("/notifications")
@Api(value = "Notifications rest service", description = "Manage notifications")
public interface NotificationController {
    @GetMapping
    @ApiOperation(value = "Get list of notifications", notes = "this return a list of some weird notifications")
    List<Notification> loadNotifications();
}