package ex04;

import java.util.Arrays;
import java.util.List;

public class SortApp {
    public static void main(String[] args) {
        // 1. sort, distinct
        List<Integer> nums = Arrays.asList(5,3,1,4,2,5);

        nums.stream()
                .sorted()
                .distinct()
                .forEach(integer -> System.out.println(integer));

    }
}
