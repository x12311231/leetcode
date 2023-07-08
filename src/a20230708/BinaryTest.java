package a20230708;

import utils.Resources;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BinaryTest {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int res;
        res = solution.binarySearch(Resources.getInt("leetCode20230708.1.properties"), -2, -1);
        System.out.println(-1 == res);
        res = solution.binarySearch(new int[]{1}, 1, -1);
        assert res == 0;
        System.out.println(0 == res);
        int[] haystack1 = {-1, -1, -1, 1, 1, 1, 1, 1, 1};
        res = solution.binarySearch(haystack1, 1, -1);
        int a1 = Arrays.binarySearch(haystack1, 1);
        System.out.println(res == a1);
        res = solution.binarySearch(haystack1, -2, -1);
        a1 = Arrays.binarySearch(haystack1, -2);
        System.out.println(res == a1);
//        assert res == 3;
//        System.out.println(3 == res);
        res = solution.binarySearch(new int[]{1, 5, 34}, 1, -1);
        assert res == 0;
        System.out.println(0 == res);
        res = solution.binarySearch(new int[]{-1,10,122}, 1, -1);
        assert res == -1;
        System.out.println(-1 == res);

        int times = (int) (Math.random() * 10000) + 10;
        int range = (int) (Math.random() * 1000) + 10;
        for (int i = 0; i < times; i++) {
            int len = (int) (Math.random() * 100) + 10;
            int[] haystack = new int[len];
            for (int j = 0; j < len; j++) {
                haystack[j] = (int) (Math.random() * range) * (Math.random() > 0.5 ? 1 : -1);
            }
            Arrays.sort(haystack);
            int target = (int) (Math.random() * range) * (Math.random() > 0.5 ? 1 : -1);
            int i1 = Arrays.binarySearch(haystack, target);
            int r = solution.binarySearch(haystack, target, -1);
            if (i1 != r && i1 > 0 && i1 < haystack.length) {
                System.out.println("test fail");
                P(haystack);
                System.out.println("target:" + target);
                System.out.println("i1:" + i1);
                System.out.println("r:" + r);

            }
        }
        ;
    }
    public static void P(int[] arr) {
        System.out.println();
        for (int a: arr) {
            System.out.print(a + " == ");
        }
        System.out.println();
    }
}
