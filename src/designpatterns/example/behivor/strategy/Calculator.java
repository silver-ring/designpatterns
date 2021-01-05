package designpatterns.example.behivor.strategy;

public class Calculator {

    private final AlgorithmicOperation algorithmicOperation;

    public Calculator(AlgorithmicOperation algorithmicOperation) {
        this.algorithmicOperation = algorithmicOperation;
    }

    public int doOperation(int firstNum, int secondNum) {
        return this.algorithmicOperation.execute(firstNum, secondNum);
    }

}
