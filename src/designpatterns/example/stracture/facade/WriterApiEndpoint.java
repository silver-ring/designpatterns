package designpatterns.example.stracture.facade;

/**
 * Concept:
 * Have a fat class which will work as interface for complex structure
 * <p>
 * Why you should use the pattern::
 * If you have a module and the module contain a set of main interface methods and you would like to reduce complexity
 * of calling directly calling the interface, you can create facade as a hub to interact with the module
 * <p>
 * Why you shouldn't use the pattern:
 * Creating fat classes sometimes add into complexity, and could be complex by time specially if responsibility for
 * facade start to be behind being un interface
 * <p>
 * Use Case:
 * <p>
 * Common use case is api endpoint class which call a set of services to execute certain action, on this case we can
 * consider api class as a facade
 */

public class WriterApiEndpoint {

    private final PeperService peperService;
    private final PenService penService;
    private final EraserService eraserService;

    public WriterApiEndpoint() {
        this.peperService = new PeperService();
        this.penService = new PenService();
        this.eraserService = new EraserService();
    }

    public void deleteWord(String word) {
        this.peperService.setText(this.eraserService.deleteWord(this.peperService, word));
    }

    public void setColor(String color) {
        this.penService.setColor(color);
    }

    public String getColor() {
        return this.penService.getColor();
    }

    public void writeWord(String word) {
        this.peperService.setText(this.penService.writeWord(this.peperService, word));
    }

    public String getText() {
        return this.peperService.getText();
    }

}
