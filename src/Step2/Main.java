package Step2;

import java.util.Scanner;

public class Main {
    static void main() {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; ; i++) {
            System.out.println("계산할 숫자를 입력해주세요.");
            System.out.println("숫자 1:");
            int num1 = sc.nextInt();
            sc.nextLine(); // 범퍼
            System.out.println("연산자 (+, -, *, /) ");
            String operator = sc.nextLine();
            System.out.println("숫자 2:");
            int num2 = sc.nextInt();
            sc.nextLine(); // 범퍼

            switch (operator) {
                case "+":
                    calculator.plus(num1, num2);
                    break;
                case "-":
                    calculator.minus(num1, num2);
                    break;
                case "*":
                    calculator.multiply(num1, num2);
                    break;
                case "/":
                    calculator.divide(num1, num2);
                    break;
            }

            int action;
            for (; ; ) {
                System.out.println("1. 계산 2. 마지막 결과 삭제 0. 종료");
                action = sc.nextInt();
                if (action == 1) {
                    System.out.println("계산을 시작합니다.\n");
                    break;
                } else if (action == 2) {
                    calculator.removeResult();
                } else if (action == 0) {
                    break;
                } else {
                    System.out.println("\n다시 입력해주세요.");
                }
            }
            if (action == 0) { break; }

        }
    }
}
