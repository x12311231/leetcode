package a20230708;

import a20230701.Solution2;
import utils.Resources;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] res;
        res = solution.twoSum(Resources.getInt("leetCode20230708.1.properties"), -2);
        res = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println(assertEqual(new int[]{1, 2}, res));

        res = solution.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(assertEqual(new int[]{1, 2}, res));

        res = solution.twoSum(new int[]{2,7,11,15}, 22);
        System.out.println(assertEqual(new int[]{2, 4}, res));
        res = solution.twoSum(new int[]{3,2,4}, 6);
        System.out.println(assertEqual(new int[]{2, 3}, res));
        res = solution.twoSum(new int[]{3,2,4}, 7);
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
