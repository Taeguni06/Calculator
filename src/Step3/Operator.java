package Step3;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;

public enum Operator {
    PLUS("+", Double::sum), // 같은 동작 (a,b) -> a + b
    MINUS("-", (a,b) -> a - b),
    MULTIPLY("*", (a,b) -> a * b),
    DIVIDE("/", (a,b) -> a / b);


    private final DoubleBinaryOperator op;
    private final String symbol;

    Operator(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double a, double b){
        return op.applyAsDouble(a, b);
    }

    public static Operator fromSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(type -> type.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }

}
