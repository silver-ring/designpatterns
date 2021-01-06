package designpatterns.example.behivor.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArthmaticOperationTest {

    @Test
    public void doCalculations() {
        Calculator additionCalculator = new Calculator(new Addition());
        int additionResult = additionCalculator.doOperation(10, 10);
        assertEquals(20, additionResult);

        Calculator subtractCalculator = new Calculator(new Addition());
        int subtractResult = subtractCalculator.doOperation(10, 10);
        assertEquals(0, subtractResult);
    }

}