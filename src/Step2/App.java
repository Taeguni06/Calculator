// InputMisMatchException 처리

package Step2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static void main() {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        int action;
        for (; ; ) {
            try {
                System.out.println("1. 계산 2. 최근 기록 삭제 3. 마지막 기록 삭제 0. 종료 | 기록 =" + calculator.getResult());
                action = sc.nextInt();
                if (action == 1) {
                    try {
                        for (;;) {
                            System.out.println("계산할 숫자를 입력해주세요.");
                            System.out.println("숫자 1:");
                            int num1 = sc.nextInt();
                            sc.nextLine(); // 범퍼

                            System.out.println("연산자 (+, -, *, /) ");
                            String operator = sc.nextLine();

                            System.out.println("숫자 2:");
                            int num2 = sc.nextInt();
                            sc.nextLine(); // 범퍼

                            calculator.calculate(num1,num2,operator);
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("정수를 입력해주세요.");
                        sc.nextLine();
                    }
                } else if (action == 2) {
                    calculator.removeResultLast();
                } else if (action == 3) {
                    calculator.removeResultFirst();
                } else if (action == 0) {
                    break;
                } else {
                    System.out.println("다시 입력해주세요.");
                }
            }catch (InputMismatchException e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
//                            switch (operator) {
//                                case "+":
//                                    calculator.plus(num1, num2);
//                                    break;
//                                case "-":
//                                    calculator.minus(num1, num2);
//                                    break;
//                                case "*":
//                                    calculator.multiply(num1, num2);
//                                    break;
//                                case "/":
//                                    calculator.divide(num1, num2);                                    //수정 전
//                                    break;
//                                default:
//                                    System.out.println("연산자를 다시 입력해주세요.");
//                            }
//                            break;
