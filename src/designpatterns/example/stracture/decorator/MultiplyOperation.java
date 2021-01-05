package designpatterns.example.stracture.decorator;

public class MultiplyOperation implements AlgorithmicOperation {

    @Override
    public double execute(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }
}
