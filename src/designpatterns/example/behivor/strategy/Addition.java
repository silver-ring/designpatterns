package designpatterns.example.behivor.strategy;

public class Addition implements AlgorithmicOperation {
    @Override
    public int execute(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
