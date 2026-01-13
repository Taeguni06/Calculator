package Step2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> result = new ArrayList<>();

    void calculate(int a, int b, String oper) {
        switch (oper) {
            case "+": result.add(a+b); break;
            case "-": result.add(a-b); break;
            case "*": result.add(a*b); break;
            case "/": if (b==0) {
                System.out.println("0으로는 나눌 수 없습니다.");
            } else {
                result.add(a/b);
            }  break;
        }
        System.out.println("계산 기록:" + result);
    }


//    void plus(int a, int b){
//        result.add(a + b);
//        System.out.println("계산 기록:" + result);
//    }
//
//    void minus(int a, int b){
//        result.add(a - b);
//        System.out.println("결과값: " + getResultLast());
//    }
//
//    void multiply(int a, int b){                                          //수정전
//        result.add(a * b);
//        System.out.println("결과값: " + getResultLast());
//    }
//
//    void divide(int a, int b){
//        result.add(a / b);
//        System.out.println("결과값: " + getResultLast());
//    }
//
    void removeResultFirst() {
        if (result.isEmpty()) {
            System.out.println("\n기록이 없습니다.");
        }else {
            result.removeFirst();
        }
    }

    void removeResultLast() {
        if (result.isEmpty()) {
            System.out.println("\n기록이 없습니다.");
        }else {
            result.removeLast();
        }
    }

    ArrayList<Integer> getResult() {
        return result;
    }
    int getResultLast () {
        return result.getLast();
    }

}
