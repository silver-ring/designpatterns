package designpatterns.example.stracture.adaptor;

public interface DataServiceV1 {

    int saveText(int index, String text);

    String getText(int index);

}
