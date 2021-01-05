package designpatterns.example.stracture.adaptor;

import java.util.ArrayList;
import java.util.List;

public class DataServiceV1Impl implements DataServiceV1 {

    List<String> textList = new ArrayList<>();

    @Override
    public int saveText(int index, String text) {
        textList.add(index, text);
        return index;
    }

    @Override
    public String getText(int index) {
        return textList.get(index);
    }

}
