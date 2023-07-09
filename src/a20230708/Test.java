package a20230708;

import utils.Resources;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
//        Solution solution = new Solution();
        Solution1 solution = new Solution1();
//        Solution2 solution = new Solution2();
        int[] res;
        res = solution.twoSum(Resources.getInt("leetCode20230708.1.properties"), -2);
        res = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println(assertEqual(new int[]{1, 2}, res));
        res = solution.twoSum(new int[]{1, 3, 3}, 6);
        System.out.println(assertEqual(new int[]{2, 3}, res));
        res = solution.twoSum(new int[]{-43, -34, -30, -25, - 19, -5, 1, 3, 3, 6, 23, 33, 36, 39}, -28);
        System.out.println(assertEqual(new int[]{2, 10}, res));

        res = solution.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(assertEqual(new int[]{1, 2}, res));

        res = solution.twoSum(new int[]{2,7,11,15}, 22);
        System.out.println(assertEqual(new int[]{2, 4}, res));
        res = solution.twoSum(new int[]{-3,2,4}, 6);
        System.out.println(assertEqual(new int[]{2, 3}, res));
        res = solution.twoSum(new int[]{3,3,4}, 7);
        System.out.println(assertEqual(new int[]{1, 3}, res));
    }
    public static boolean assertEqual(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                return false;
            }
        }
        return true;
    }
}
