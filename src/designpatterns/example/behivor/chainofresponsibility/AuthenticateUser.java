package designpatterns.example.behivor.chainofresponsibility;

public class AuthenticateUser extends Middleware {

    public AuthenticateUser(Middleware next) {
        super(next);
    }

    public AuthenticateUser() {
        super();
    }

    @Override
    public ResponseObj execute(RequestObj requestObj, ResponseObj responseObj) {
        if (!Data.users.get(requestObj.getUserId()).contains(requestObj.getDataId())) {
            throw new RuntimeException("unauthorized request");
        }
        return responseObj;
    }

}
