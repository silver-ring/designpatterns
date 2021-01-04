package designpatterns.example.creation.factory;

public class RedPen implements Pen {
    @Override
    public String write(String word) {
        return String.format("RED: %s", word);
    }
}
