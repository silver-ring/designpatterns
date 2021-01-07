package designpatterns.example.behivor.strategy;

public class Subtract implements AlgorithmicOperation{

    @Override
    public int execute(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

}
