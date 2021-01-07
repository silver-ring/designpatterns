package designpatterns.example.behivor.chainofresponsibility;

public abstract class Middleware {

    protected final Middleware next;

    public Middleware(Middleware next) {
        this.next = next;
    }

    public Middleware() {
        this(null);
    }

    public ResponseObj dispatch(RequestObj requestObj) {
        ResponseObj responseObj = new ResponseObj();
        return dispatch(requestObj, responseObj);
    }

    protected ResponseObj dispatch(RequestObj requestObj, ResponseObj responseObj) {
        ResponseObj newResponseObj = execute(requestObj, responseObj);
        if (next == null) {
            return newResponseObj;
        } else {
            return next.dispatch(requestObj, newResponseObj);
        }
    }

    protected abstract ResponseObj execute(RequestObj requestObj, ResponseObj responseObj);


}
