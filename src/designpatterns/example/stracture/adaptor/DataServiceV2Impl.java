package designpatterns.example.stracture.adaptor;

import java.util.HashMap;
import java.util.Map;

public class DataServiceV2Impl implements DataServiceV2 {
    Map<Long, String> data = new HashMap<>();

    public long saveData(long id, String text) {
        data.merge(id, text, String::concat);
        return id;
    }

    public String getData(long id) {
        return data.get(id);
    }

}
