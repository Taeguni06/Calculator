package Step2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> result = new ArrayList<>();

    Calculator() {

    }

    void plus(int a, int b){
        result.add(a + b);
        System.out.println("계산 기록:" + result);
    }

    void minus(int a, int b){
        result.add(a - b);
        System.out.println("결과값: " + getResultLast());
    }

    void multiply(int a, int b){
        result.add(a * b);
        System.out.println("결과값: " + getResultLast());
    }

    void divide(int a, int b){
        result.add(a / b);
        System.out.println("결과값: " + getResultLast());
    }

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
