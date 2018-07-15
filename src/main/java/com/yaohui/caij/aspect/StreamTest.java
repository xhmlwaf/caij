
package com.yaohui.caij.aspect;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        test3();
    }

    private static void test1() {
        int[] nums = new int[]{1, 3, 4, 6, 7, 8, 9};
        Arrays.stream(nums).filter(i -> i % 2 != 0).forEach(i -> System.out.print(i));
    }

    private static void test2() {
        String[] names = new String[]{"abc", "yaya", "yaohui", "home"};
        Arrays.stream(names).map(s->s.toUpperCase()).forEach(s->System.out.print(s+","));
    }

    private static void test3() {
        int[] nums = new int[]{1, 3, 4, 6, 7, 8, 9};
        int a = Arrays.stream(nums).filter(i -> i % 2 != 0).sum();
        System.out.println(a);
    }


}
