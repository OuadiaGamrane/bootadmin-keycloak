package ma.oga.microsystemes.myservice.repository;

import ma.oga.microsystemes.myservice.domaine.Notification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NotificationRepositoryIntTest {

    @Autowired
    NotificationRepository notificationRepository;

    @Before
    public void initDb() {
        Notification notification = new Notification();
        notification.setContent("Test");
        notification.setTitle("Title");
        notificationRepository.save(notification);
    }

    @Test
    public void test_Count() {
        Assert.assertEquals(1,notificationRepository.count());
    }

}
