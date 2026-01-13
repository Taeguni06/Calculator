package Step3;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Double> result = new ArrayList<>();

    void calculate(double a, double b,String op) {
        double resultValue = Operator.fromSymbol(op).apply(a,b);
        result.add(resultValue);
        System.out.println("resultValue = " + resultValue);
    }
}
