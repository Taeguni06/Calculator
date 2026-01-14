package Step3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class Calculator<T extends Number>{
    private final ArrayList<T> result = new ArrayList<>();
    private final Function<Double, T> resultConverter;

    public Calculator(Function<Double, T> resultConverter) {
        this.resultConverter = resultConverter;
    } //

    void calculate(T a, T b,String op) {
        double resultValue = Operator.fromSymbol(op).apply(a,b);

        T finalResult = resultConverter.apply(resultValue); // 형변환
        result.add(finalResult);

        System.out.println("결과: " + finalResult);
    }

    void numberFinder(double n) {
        result.stream()
                .filter(x -> x.doubleValue() > n)
                .forEach(x -> System.out.println("더 큰 값: " + x));
    }

    public ArrayList<T> getResult() {
        return result;
    }

    // App에서 action 입력 받는 Scanner 재활용
    static <T extends Number> void runCalculator(Scanner sc , Calculator<T> cal, Function<String, T> converter) {
        while (true) {
            try {
                System.out.print("계산 기록 " + cal.getResult() + "\n숫자 1: ");
                String input1 = sc.next();
                if (input1.equals("exit")) break;

                System.out.print("연산자 (+, -, *, /): ");
                String op = sc.next();

                System.out.print("숫자 2: ");
                String input2 = sc.next();

                T n1 = converter.apply(input1);
                T n2 = converter.apply(input2);

                cal.calculate(n1, n2, op);

            } catch (Exception e) {
                System.out.println("[입력 오류] 다시 입력해주세요.");
                sc.nextLine();
            }                       // runCalculator 실행시 input1, input2, op 입력 받고 ex) n1에 convert.apply(input) ==
        }
    }
}
