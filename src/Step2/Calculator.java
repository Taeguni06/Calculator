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
        System.out.println("계산 기록:" + result);
    }

    void multiply(int a, int b){
        result.add(a * b);
        System.out.println("계산 기록:" + result);
    }

    void divide(int a, int b){
        result.add(a / b);
        System.out.println("계산 기록:" + result);
    }

    void removeResult() {
        if (result.isEmpty()) {
            System.out.println("\n검색 기록이 없습니다.");
        }else {
            result.removeFirst();
            System.out.println("계산 기록:" + result);
        }
    }

    int getResult (int a) {
        return result.get(a);
    }

}
