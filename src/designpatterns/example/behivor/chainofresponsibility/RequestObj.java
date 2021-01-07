package designpatterns.example.behivor.chainofresponsibility;

public class RequestObj {

    private long userId;
    private long dataId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }
}
