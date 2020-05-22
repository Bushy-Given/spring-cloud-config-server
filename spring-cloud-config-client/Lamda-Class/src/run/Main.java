package run;

import util.Consumer;
import util.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bushy-Netshidaulu
 * on 5/22/2020
 */
public class Main {

    public static void main(String[] args) {
        testMyConsumer();
        testMyPredicate();
    }

    private static void testMyPredicate() {
        Predicate<String> p = String::isBlank;
        Predicate<String> pNot = p.negate();
        Predicate<String> and = p.and(pNot);

        Predicate<Integer> n1 = i-> i.equals(25);
        Predicate<Integer> n2 = i1 -> i1.equals(30);

        Predicate<Integer> isTrue = n1.or(n2);

        Predicate<Integer> xor = n1.xOr(n2);

        System.out.println("is true? " + isTrue.test(30));
        System.out.println("is also true? " +  isTrue.test(25));
        System.out.println("is this true aswel? " + isTrue.test(15));

        System.out.println("xor : " + xor.test(30));


        System.out.println("blank ?" + p.test(""));
        System.out.println("blank ?" + pNot.test(""));
    }

    private static void testMyConsumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello");

        Consumer<List<String>> c1 = list -> list.add("bushy");
        Consumer<List<String>> c2 = list -> list.add("Given");

        //chain of predicates
        Consumer<List<String>> andThen = c1.andThen(c2);
    }
}
