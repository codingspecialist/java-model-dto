package ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 니 왜 1주 됐는데 돈 20만원 안갚는데?
 *
 * 니 일하기전에 얼마 있었는데? 31500원
 *
 * 그럼 1주일 일했으면 갚아야지!!
 *
 * 아직 20만원이 없어!!
 *
 * 하루에 얼마 버는데, 매일 달라!!
 *
 * 27000, 32000, 40000, 10000, 40000, 20000, 28000
 */
public class ReduceApp {
    public static void main(String[] args) {
        int origin = 31500;
        List<Integer> list = Arrays.asList(27000, 32000, 40000, 10000, 40000, 20000, 28000);

        int sum = list.stream()
                .map(integer -> integer - 2000)
                .reduce(origin, (x, y) -> x + y);
        System.out.println("니가 들고 있는 돈 : "+sum);
    }
}
