package com.claudio.learninglambda.lambdas_01_04;

/**
 * lambdas_01_04
 */
public class lambdas_01_04 {

    public static void main(String[] args) {
        
        Calculate add = (a, b) -> a+b;
        Calculate difference = (a, b) -> a-b;
        Calculate divide = (a, b) -> (b != 0 ? a / b : 0);
        Calculate multiply = (e, f) -> e*f;
        Calculate myMultiply = (r, t) -> {
            System.out.println("My multiply");
            return r*t;
        };

        System.out.println(add.calc(10, 15));
        System.out.println(difference.calc(20, 3));
        System.out.println(divide.calc(40, 3));
        System.out.println(divide.calc(27, 0));
        System.out.println(multiply.calc(4, 33));
        System.out.println(myMultiply.calc(45, 23));
    }
}