package Step2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> result = new ArrayList<>();

    Calculator() {

    }

    void plus(int a, int b){
        result.add(a + b);
    }

    void minus(int a, int b){
        result.add(a - b);
    }
    void multiply(int a, int b){
        result.add(a * b);
    }
    void divide(int a, int b){
        result.add(a / b);
    }

    void removeResult() {
       result.removeFirst();
    }

    int getResult (int a) {
        return result.get(a);
    }

    public ArrayList<Integer> getResultList () {
        return result;
    }

}
