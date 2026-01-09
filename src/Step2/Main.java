package Step2;

import java.util.Scanner;

public class Main {
    static void main() {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in); // test

        for (int i = 0; ; i++) {
            System.out.println("i= " + i);
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
            System.out.println("결과값: " + calculator.getResult(i));



            System.out.println("1. 계산 2. 전체 조회 3. 마지막 결과 삭제 0. 종료");
            String action = sc.nextLine();
            switch (action) {
                case "2":
                    System.out.println(calculator.getResultList());
                    calculator.plus(0,0);
                case "3":
                    calculator.removeResult();
                case "0":
                    break;
            }
        }

    }
}
