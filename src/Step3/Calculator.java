package Step3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

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

    void bigFinder(double n) { // 입력한 값보다 큰 값 출력
        result.stream()
                .filter(x -> x.doubleValue() > n)
                .forEach(x -> System.out.println("더 큰 값: " + x));
    }

    void smallFinder(double n) { // 입력한 값보다 큰 값 출력
        result.stream()
                .filter(x -> x.doubleValue() < n)
                .forEach(x -> System.out.println("더 작은 값: " + x));
    }

    public ArrayList<T> getResult() { // 기록 조회
        return result;
    }

    void removeResult (int a) { // 계산 기록 삭제
        if (result.isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
        } else {
            result.remove(a);
        }
    }

    void removeResultAll () { // 계산 기록 삭제
        if (result.isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
        } else {
            result.clear();
        }
    }

    // App에서 action 입력 받는 Scanner 재활용
    static <T extends Number> void runCalculator(Scanner sc , Calculator<T> cal, Function<String, T> converter) {
        label:
        while (true) {
            try {
                System.out.print("숫자 1: ");
                String input1 = sc.next();
                label1:
                switch (input1) {
                    case "exit":
                        break label;


                    case "remove":
                        System.out.println("1. 선택 삭제 2. 전체 삭제 0. 종료");
                        String remove = sc.next();
                        switch (remove) {
                            case "1":
                                System.out.println("계산 기록: " + cal.getResult());
                                System.out.println("몇 번 항목을 삭제하시겠습니까? (왼쪽부터 0번)");
                                int removeNum = sc.nextInt();
                                cal.removeResult(removeNum);
                                System.out.println("계산 기록: " + cal.getResult());
                                break;
                            case "2":
                                if (cal.result.isEmpty()) {
                                    System.out.println("계산 기록이 없습니다.");
                                } else {
                                    System.out.println("전체 기록을 삭제했습니다.");
                                    cal.removeResultAll();
                                    System.out.println("계산 기록: " + cal.getResult());
                                }
                                break;
                        }
                        break;


                    case "history":  // 조회
                        System.out.println("계산 기록: " + cal.getResult());
                        System.out.println("1. 큰 값 찾기 2. 작은 값 찾기 0. 종료");
                        String history = sc.next();
                        switch (history) {
                            case "1": {
                                System.out.println("입력하신 값보다 큰 값만 출력합니다.");  // 더 큰 값 출력


                                double compare = sc.nextDouble();
                                cal.bigFinder(compare);
                                break;
                            }
                            case "2": {
                                System.out.println("입력하신 값보다 작은 값만 출력합니다."); // 더 작은 값 출력


                                double compare = sc.nextDouble();
                                cal.smallFinder(compare);
                                break;
                            }
                            case "0":
                                break label1;
                            default:
                                System.out.println("해당하는 기능이 없습니다.");
                                break;
                        }
                        break;


                    case "fix":  // 수정
                        System.out.println("수정을 원하시는 번호를 입력해주세요 (왼쪽부터 0번) 나가시려면 exit 입력 ");
                        System.out.println("계산 기록: " + cal.getResult());
                        String fix = sc.next();
                        if(fix.equals("exit")) {
                            System.out.println("종료합니다.");
                            break;
                        } else {
                            int num = Integer.parseInt(fix);
                            System.out.println("수정하실 숫자를 입력해주세요.");
                            String fixedNum = sc.next();
                            T fixed = converter.apply(fixedNum);
                            cal.result.set(num, fixed);
                            System.out.println("계산 기록: " + cal.getResult());
                        }
                        break;


                    default:                       // 생성
                        System.out.print("연산자 (+, -, *, /): ");
                        String op = sc.next();

                        System.out.print("숫자 2: ");
                        String input2 = sc.next();

                        T n1 = converter.apply(input1);
                        T n2 = converter.apply(input2);

                        cal.calculate(n1, n2, op);
                        break;
                }

            } catch (Exception e) {
                System.out.println("[입력 오류] 다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
