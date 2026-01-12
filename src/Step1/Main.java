package Step1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        for (;;) {
            try {
                System.out.println("계산할 숫자를 입력해주세요.");
                System.out.println("숫자 1:");
                int num1 = sc.nextInt();
                sc.nextLine(); // 범퍼
                System.out.println("연산자 (+, -, *, /) ");
                String operator = sc.nextLine();
                System.out.println("숫자 2:");
                int num2 = sc.nextInt();
                sc.nextLine(); // 범퍼

                if (operator.equals("+")) {
                    result = num1 + num2;
                }

                if (operator.equals("-")) {
                    result = num1 - num2;
                }

                if (operator.equals("*")) {
                    result = num1 * num2;
                }

                if (operator.equals("/")) {
                    result = num1 / num2;
                }
                System.out.println("결과값: " + result);

                System.out.println("계산기를 계속 하시려면 아무 숫자를 입력해주세요 (exit 입력시 종료)");
                String exit = sc.nextLine();
                if (exit.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
