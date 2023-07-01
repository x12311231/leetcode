package a20230701;

public class Test {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        Solution1 solution = new Solution1();
        Solution2 solution = new Solution2();
        int[] res;
        res = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println(assertEqual(new int[]{0, 1}, res));

        res = solution.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(assertEqual(new int[]{0, 1}, res));

        res = solution.twoSum(new int[]{2,7,11,15}, 22);
        System.out.println(assertEqual(new int[]{1, 3}, res));
        res = solution.twoSum(new int[]{3,2,4}, 6);
        System.out.println(assertEqual(new int[]{1, 2}, res));
        res = solution.twoSum(new int[]{3,2,4}, 7);
        System.out.println(assertEqual(new int[]{0, 2}, res));
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
