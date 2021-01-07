package designpatterns.example.behivor.chainofresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MiddlewareTest {


    @Test
    public void executeChain() {
        ApiEndpoint apiEndpoint = new ApiEndpoint();

        String text1 = apiEndpoint.getData(10l, 1l);
        assertEquals(Data.data.get(1l), text1);

        Exception unauthorizedException = assertThrows(RuntimeException.class,
                () -> apiEndpoint.getData(10l, 2l));
        assertEquals("unauthorized request", unauthorizedException.getMessage());

        Exception userNotFoundException = assertThrows(RuntimeException.class,
                () -> apiEndpoint.getData(50l, 3l));
        assertEquals("user not found", userNotFoundException.getMessage());
    }
}