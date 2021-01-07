package designpatterns.example.behivor.chainofresponsibility;

public class ValidateInput extends Middleware {


    public ValidateInput(Middleware next) {
        super(next);
    }

    public ValidateInput() {
        super();
    }

    @Override
    public ResponseObj execute(RequestObj requestObj, ResponseObj responseObj) {
        if (!Data.users.containsKey(requestObj.getUserId())) {
            throw new RuntimeException("user not found");
        }
        if (!Data.data.containsKey(requestObj.getDataId())) {
            throw new RuntimeException("data not found");
        }
        return responseObj;
    }

}
