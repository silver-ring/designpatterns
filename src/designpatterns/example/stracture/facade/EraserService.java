package designpatterns.example.stracture.facade;

public class EraserService {

    public String deleteWord(PeperService peperService, String word) {
        return peperService.getText().replace(word, "");
    }

}
