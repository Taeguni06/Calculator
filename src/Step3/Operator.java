package Step3;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (n1, n2) -> n1 + n2),
    MINUS("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private final String symbol;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public double calculate(double n1, double n2) {
        return expression.apply(n1, n2);
    }
    public static Operator fromSymbol(String symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("해당하는 연산자가 없습니다: " + symbol);
    }
}
