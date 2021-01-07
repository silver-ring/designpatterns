package designpatterns.example.behivor.nullobject;

import org.junit.jupiter.api.Test;

public class NotificationTest {

    @Test
    public void notifyUser() {

        User user = new User();

        user.setName("test");
        user.setEmail("test@test.com");
        user.setPhone("+123456789");

        NotificationService notificationService = new NotificationService();

        user.setNotifyBy(NotifyBy.NO_NOTIFICATION);
        notificationService.notifyUser(user);

        user.setNotifyBy(NotifyBy.EMAIL);
        notificationService.notifyUser(user);

        user.setNotifyBy(NotifyBy.PHONE);
        notificationService.notifyUser(user);
    }

}
