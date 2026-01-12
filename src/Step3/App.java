package Step3;
// TODO 사칙연산 클래스
// TODO Scanner 및 기본 틀
// TODO 제네릭 스트림 람다 이넘 학습 및 복습

import java.util.Scanner;

public class App {
    static void main() {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        String result = "";
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        String op = sc.nextLine();
        cal.calculate(n1, n2, op);


    }
}
