package designpatterns.example.creation.factory;

public class GreenPen implements Pen {
    @Override
    public String write(String word) {
        return String.format("GREEN: %s", word);
    }
}
