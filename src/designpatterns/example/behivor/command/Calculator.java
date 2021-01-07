package designpatterns.example.behivor.command;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<ArthmaticOperation> operations = new ArrayList<>();

    public void addOperation(ArthmaticOperation arthmaticOperation) {
        operations.add(arthmaticOperation);
    }

    public int executeOperations(int firstNumber, int secondNumber) {
        int result = 0;
        for (ArthmaticOperation operation : operations) {
            result = +operation.execute(firstNumber, secondNumber);
        }
        return result;
    }

}
