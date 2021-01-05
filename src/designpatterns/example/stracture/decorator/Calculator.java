package designpatterns.example.stracture.decorator;

public abstract class Calculator implements AlgorithmicOperation {

    final private AlgorithmicOperation algorithmicOperation;

    public Calculator(AlgorithmicOperation algorithmicOperation) {
        this.algorithmicOperation = algorithmicOperation;
    }

    @Override
    public double execute(double firstNum, double secondNum) {
        return algorithmicOperation.execute(firstNum, secondNum);
    }

}
