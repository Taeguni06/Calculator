package Step3;
// TODO 사칙연산 클래스
// TODO Scanner 및 기본 틀
// TODO 제네릭 스트림 람다 이넘 학습 및 복습

import java.util.Scanner;

public class App {
    static void main() {
        Calculator<Double> doubleCal = new Calculator<>(d -> d);
        Calculator<Integer> intCal = new Calculator<>(Double::intValue);
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("1. 정수 계산기(int) 2. 실수 계산기(double) 3. 정수 숫자 찾기 4. 실수 숫자 찾기 0. 종료");
                int action = sc.nextInt();
                if (action == 1) {
                    System.out.println("[정수 계산기] 숫자 두 개와 연산자를 입력하세요 종료: exit 기록 삭제: remove");
                    Calculator.runCalculator(sc, intCal, Integer::valueOf);
                } else if (action == 2) {
                    System.out.println("[실수 계산기] 숫자 두 개와 연산자를 입력하세요 종료: exit 기록 조회: history 기록 삭제: remove");
                    Calculator.runCalculator(sc, doubleCal, Double::valueOf);
                } else if (action == 3) {
                    System.out.println("[정수 계산기] 입력하신 값보다 큰 값을 반환합니다.");
                    double num = sc.nextDouble();
                    intCal.numberFinder(num);
                } else if (action == 4) {
                    System.out.println("[실수 계산기] 입력하신 값보다 큰 값을 반환합니다.");
                    double num = sc.nextDouble();
                    doubleCal.numberFinder(num);
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
