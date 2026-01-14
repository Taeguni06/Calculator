package Step3;

import java.util.Scanner;

public class App {
    static void main() {
        Calculator<Double> doubleCal = new Calculator<>(d -> d); //실수형
        Calculator<Integer> intCal = new Calculator<>(Double::intValue); //정수형 구분
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("1. 정수 계산기(int) 2. 실수 계산기(double) 0. 종료");
                int action = sc.nextInt();
                if (action == 1) {
                    System.out.println("[정수 계산기] 숫자 두 개와 연산자를 입력하세요 기록 조회: history 기록 수정: fix 삭제: remove 종료: exit");
                    Calculator.runCalculator(sc, intCal, Integer::valueOf);
                } else if (action == 2) {
                    System.out.println("[실수 계산기] 숫자 두 개와 연산자를 입력하세요 기록 조회: history 기록 수정: fix 삭제: remove 종료: exit");
                    Calculator.runCalculator(sc, doubleCal, Double::valueOf);
                } else if (action == 0) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("다시 입력해주세요.");
                }
            }catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                sc.next();
            }
        }
    }
}
