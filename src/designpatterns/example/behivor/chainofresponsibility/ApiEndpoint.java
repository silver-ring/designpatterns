package designpatterns.example.behivor.chainofresponsibility;

public class ApiEndpoint {

    public ApiEndpoint() {
    }

    public String getData(long userId, long dataId) {
        RequestObj requestObj = new RequestObj();
        requestObj.setUserId(userId);
        requestObj.setDataId(dataId);

        Middleware dataService = new DataService();
        Middleware authenticateUser = new AuthenticateUser(dataService);
        Middleware validateInput = new ValidateInput(authenticateUser);

        ResponseObj result = validateInput.dispatch(requestObj);

        return result.getText();
    }

}
