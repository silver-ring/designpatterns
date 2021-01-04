package designpatterns.example.creation.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenServiceFactoryTest {

    @Test
    public void createPenWithColor() {
        PenFactory penFactory = new PenFactory();

        String testWord = "test word";

        // test green
        Pen greenPen = penFactory.createPen(PenColor.GREEN);
        String greenPenResult = greenPen.write(testWord);
        String expectedGreenPenResult = String.format("GREEN: %s", testWord);
        assertEquals(expectedGreenPenResult, greenPenResult);

        // test red
        Pen redPen = penFactory.createPen(PenColor.RED);
        String redPenResult = redPen.write(testWord);
        String expectedRedPenResult = String.format("RED: %s", testWord);
        assertEquals(expectedRedPenResult, redPenResult);

        // test blue
        Pen bluePen = penFactory.createPen(PenColor.BLUE);
        String bluePenResult = bluePen.write(testWord);
        String expectedBluePenResult = String.format("BLUE: %s", testWord);
        assertEquals(bluePenResult, expectedBluePenResult);
    }
}