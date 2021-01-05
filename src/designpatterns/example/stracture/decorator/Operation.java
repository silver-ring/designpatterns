package designpatterns.example.stracture.decorator;

public class Operation extends Calculator {

    public Operation(AlgorithmicOperation algorithmicOperation) {
        super(algorithmicOperation);
    }

    @Override
    public double execute(double firstNum, double secondNum) {
        return super.execute(firstNum, secondNum);
    }
}
