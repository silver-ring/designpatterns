package designpatterns.example.stracture.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArthmaticOperationTest {

    @Test
    public void makeAlgorithmicOperationsWithExtra() {
        AlgorithmicOperation addOperation = new Operation(new AddOperation());
        double addResult = addOperation.execute(10, 10);
        assertEquals(20, addResult);

        AlgorithmicOperation subtractOperation = new Operation(new SubtractOperation());
        double subtractResult = subtractOperation.execute(10, 10);
        assertEquals(0, subtractResult);

        AlgorithmicOperation multiplyOperation = new Operation(new MultiplyOperation());
        double multiplyResult = multiplyOperation.execute(10, 10);
        assertEquals(100, multiplyResult);

        AlgorithmicOperation divideOperation = new Operation(new DivideOperation());
        double divideResult = divideOperation.execute(10, 10);
        assertEquals(1, divideResult);
    }
}