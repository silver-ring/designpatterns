package designpatterns.example.behivor.chainofresponsibility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    public static final Map<Long, String> data = new HashMap<>();
    public static Map<Long, List<Long>> users = new HashMap<>();

    static {
        long dataId1 = 1L;
        long dataId2 = 2L;
        long dataId3 = 3L;

        long userId1 = 10L;
        long userId2 = 20L;
        long userId3 = 30L;

        data.put(dataId1, "test text one");
        data.put(dataId2, "test text two");
        data.put(dataId3, "test text three");
        users.put(userId1, List.of(dataId1));
        users.put(userId2, List.of(dataId1, dataId2));
        users.put(userId3, List.of(dataId1, dataId2, dataId3));
    }


}
