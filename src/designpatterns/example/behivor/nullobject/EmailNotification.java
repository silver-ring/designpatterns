package designpatterns.example.behivor.nullobject;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser(User user) {
        sendEmail(user);
    }

    private void sendEmail(User user) {
        System.out.printf("send sms to: %s\nEmail is: %s",user.getName(), user.getEmail());
    }
}
