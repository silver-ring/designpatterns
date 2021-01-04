package designpatterns.example.creation.factory;

public class BluePen implements Pen {
    @Override
    public String write(String word) {
        return String.format("BLUE: %s", word);
    }
}
