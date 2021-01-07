package designpatterns.example.behivor.nullobject;

public class NotificationService {

    public void notifyUser(User user) {
        Notification notification = getNotification(user.getNotifyBy());
        notification.notifyUser(user);
    }

    private Notification getNotification(NotifyBy notifyBy) {
        switch (notifyBy) {
            case EMAIL:
                return new EmailNotification();
            case PHONE:
                return new SmsNotification();
            case NO_NOTIFICATION:
                return new NoNotification();
            default:
                throw new RuntimeException("Unsupported notification");
        }
    }

}
