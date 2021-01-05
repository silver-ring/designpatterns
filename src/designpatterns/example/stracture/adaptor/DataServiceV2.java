package designpatterns.example.stracture.adaptor;

public interface DataServiceV2 {

    long saveData(long id, String text);

    String getData(long id);

}
