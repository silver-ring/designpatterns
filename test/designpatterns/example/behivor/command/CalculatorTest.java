package designpatterns.example.behivor.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void executeArithmeticOperations() {
        Calculator calculator = new Calculator();

        calculator.addOperation(new Addition());
        calculator.addOperation(new Subtract());

        int result = calculator.executeOperations(10, 20);

        assertEquals(-10, result);
    }

}