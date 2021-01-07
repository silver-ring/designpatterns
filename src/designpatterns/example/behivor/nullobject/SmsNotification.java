package designpatterns.example.behivor.nullobject;

public class SmsNotification implements Notification {

    @Override
    public void notifyUser(User user) {
        sendSms(user);
    }

    private void sendSms(User user) {
        System.out.printf("send sms to: %s\nPhone Number: %s",user.getName(), user.getPhone());
    }
}
