package designpatterns.example.behivor.nullobject;

public class User {
    private String name;
    private String email;
    private String phone;
    private NotifyBy notifyBy;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NotifyBy getNotifyBy() {
        return notifyBy;
    }

    public void setNotifyBy(NotifyBy notifyBy) {
        this.notifyBy = notifyBy;
    }
}
