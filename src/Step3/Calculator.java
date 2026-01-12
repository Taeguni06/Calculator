package Step3;

import jdk.dynalink.Operation;

import java.util.function.BiFunction;

public class Calculator {
    public double calculate(double num1, double num2, String symbol) {
        // 1. 입력받은 기호(String)에 맞는 Enum을 찾습니다.
        Operator op = Operator.fromSymbol(symbol);

        // 2. 해당 Enum에게 계산을 시킵니다.
        double result = op.calculate(num1, num2);

        // 3. 결과를 리스트에 저장합니다.
        // results.add(result);

        return result;

    }
}
