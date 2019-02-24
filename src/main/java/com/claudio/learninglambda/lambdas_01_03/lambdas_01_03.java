package com.claudio.learninglambda.lambdas_01_03;

import java.math.BigInteger;
import java.util.function.*;
/**
 * lambdas_01_03
 */
public class lambdas_01_03 {

    public static void main(String[] args) {
        
        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("Expected value 3, actual value: "
            + intToString.apply(123).length());
        
        //static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("Expected value 4, actual value: "
            + intToString2.apply(321).length());

        //lambdas made using a constructor
        Function<String, BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value 12345678910, actual value: "+
            newBigInt.apply("12345678910"));

        //example of a lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");

        //these two are the same using the static method concat
        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println(greeting.apply("world!"));

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Cláudio"));
    }
}