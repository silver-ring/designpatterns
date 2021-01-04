package designpatterns.example.stracture.facade;

public class PenService {

    private String color = "BLACK";

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String writeWord(PeperService peperService, String word) {
        String text = peperService.getText();
        return text.concat(String.format("%s: %s \n", this.getColor(), word));
    }

}
