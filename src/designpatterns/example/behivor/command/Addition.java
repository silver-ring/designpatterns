package designpatterns.example.behivor.command;

public class Addition implements ArthmaticOperation {
    @Override
    public int execute(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
