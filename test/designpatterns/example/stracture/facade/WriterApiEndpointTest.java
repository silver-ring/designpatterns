package designpatterns.example.stracture.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WriterApiEndpointTest {

    @Test
    public void testWritingHelloOnGreen() {
        WriterApiEndpoint writerApiEndpoint = new WriterApiEndpoint();
        writerApiEndpoint.setColor("Green");
        writerApiEndpoint.writeWord("Hello World");
        writerApiEndpoint.writeWord("My name is Mohamed");
        String textBeforeDelete = writerApiEndpoint.getText();
        writerApiEndpoint.deleteWord("Hello World");
        String textAfterDelete = writerApiEndpoint.getText();
        writerApiEndpoint.setColor("Blue");
        writerApiEndpoint.writeWord("My name is Mohamed");
        String textAfterChangingColor = writerApiEndpoint.getText();

        String expectedTextBeforeDelete = "Green: Hello World \n" +
                "Green: My name is Mohamed \n";
        String expectedTextAfterDelete = "Green:  \n" +
                "Green: My name is Mohamed \n";
        String expectedTextAfterChangingColor = "Green:  \n" +
                "Green: My name is Mohamed \n" +
                "Blue: My name is Mohamed \n";

        assertEquals(expectedTextBeforeDelete, textBeforeDelete);
        assertEquals(expectedTextAfterDelete, textAfterDelete);
        assertEquals(expectedTextAfterChangingColor, textAfterChangingColor);
    }
}