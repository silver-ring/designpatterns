package designpatterns.example.stracture.adaptor;

public class ApiEndpoint {

    private int currentIndex = -1;

    private final DataServiceV1 dataServiceV1;

    public ApiEndpoint(DataServiceV1 dataServiceV1) {
        this.dataServiceV1 = dataServiceV1;
    }

    public int validateAndSaveText(String text) {
        if (text == null || text.isEmpty()) {
            throw new RuntimeException("Text is required");
        }
        return this.dataServiceV1.saveText(++currentIndex, text);
    }

    public String validateAndGetText(int index) {
        if (index < 0) {
            throw new RuntimeException("Index is not valid");
        }
        return this.dataServiceV1.getText(index);
    }

}
