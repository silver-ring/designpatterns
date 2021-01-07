package designpatterns.example.behivor.nullobject;

public class NoNotification implements Notification{
    @Override
    public void notifyUser(User user) {
        // do nothing
    }

}
