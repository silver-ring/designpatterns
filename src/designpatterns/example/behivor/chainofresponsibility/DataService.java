package designpatterns.example.behivor.chainofresponsibility;

public class DataService extends Middleware {

    public DataService(Middleware next) {
        super(next);
    }

    public DataService() {
        super();
    }

    public ResponseObj execute(RequestObj requestObj, ResponseObj responseObj) {
        String data = Data.data.get(requestObj.getDataId());
        responseObj.setId(requestObj.getDataId());
        responseObj.setText(data);
        return responseObj;
    }

}
