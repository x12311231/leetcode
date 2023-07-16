package a20230715;

import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        s1(new Solution());
//        s1(new Solution1());
//        testScope();
//        testOverflowInt();
//        testOverflowLong();
//        System.out.println(Integer.MAX_VALUE >= Math.pow(10, 9));
    }

    public static void testScope() {
       int i = 1000000000 + 1000000000 + 1000000000 + 1000000000;
        int iu = - 1000000000 - 1000000000 - 1000000000 - 1000000000;
        long l = 1000000000 + 1000000000 + 1000000000 + 1000000000;
        long ll = 1000000000 + 100000000 + 100000000 + 100000000;
        int ii = 1000000000;
        int iii = (int) Math.pow(10, 9);
        int i1 = (int) Math.pow(10, 2);
        Double d = Math.pow(10, 9);
        System.out.println(d.MAX_VALUE);
    }

    public static void s1(C solution) {
        System.out.println(solution.getClass());
        assert1(solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296), -294967296, 0);
        assert1(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0), 0, 3);
        assert1(solution.fourSum(new int[]{1, 0, -1, 1, 0, -2, 2}, 0), 0, 4);
        assert1(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8), 8, 1);
        assert1(solution.fourSum(new int[]{-494,-487,-471,-470,-465,-462,-447,-445,-441,-432,-429,-422,-406,-398,-397,-364,-344,-333,-328,-307,-302,-293,-291,-279,-269,-269,-268,-254,-198,-181,-134,-127,-115,-112,-96,-94,-89,-58,-58,-58,-44,-2,-1,43,89,92,100,101,106,106,110,116,143,156,168,173,192,231,248,256,281,316,321,327,346,352,353,355,358,365,371,410,413,414,447,473,473,475,476,481,491,498}, 8511), 8511, 0);
    }
    public static void assert1(List<List<Integer>> lists, int target, int expectedSize) {
        for (List l1: lists) {
            int sum = 0;
            for (Object ii: l1) {
                sum += (Integer) ii;
            }
            boolean x = sum == target;
            System.out.println("assert:" + x);
            System.out.println("sum:" + sum);
            if (!x) {
                System.out.println("l1:" + l1);
            }
        }
        System.out.println("expected size:" + (lists.size() == expectedSize));
//        if (lists.size() != expectedSize) {
//            System.out.println("expectedSize:" + expectedSize + " lists.size():" + lists.size());
//        }
    }

    public static void testOverflowInt() {
        System.out.println(isOverflow(new int[]{2147483647, 1, 1}));
        System.out.println(isOverflow(new int[]{2147483647, 2, 1}));
//        System.out.println(isOverflow(new int[]{1000000000,1000000000,1000000000,1000000000}));
    }

    public static void testOverflowLong() {
        System.out.println(isOverflow(new long[]{1000000000,1000000000,1000000000,1000000000}));
        System.out.println(isOverflow(new long[]{2147483647, 1, 1}));
        System.out.println(isOverflow(new long[]{2147483647, 2, 1}));
    }

    public static void testOverflowByte() {
        boolean res;
//        res = isOutOfBounds(new byte[]{50, 50});
//        System.out.println(res == true);
//

        res = isOverflow(new byte[]{-50, -50, -50});
        System.out.println(res == false);
        res = isOverflow(new byte[]{50, 50, 50});
        System.out.println(res == false);

        res = isOverflow(new byte[]{50, 50, -50, 50});
        System.out.println(res == true);
        res = isOverflow(new byte[]{50, 70, -50, 70});
        System.out.println(res == false);
        res = isOverflow(new byte[]{50, 70, -50, 70, -50});
        System.out.println(res == false);
        res = isOverflow(new byte[]{-100, -27, -1, 5, 10});
        System.out.println(res == false);
        res = isOverflow(new byte[]{-100, -27, 5, 10});
        System.out.println(res == true);
        res = isOverflow(new byte[]{-100, -27, 5, 10, 100, 100});
        System.out.println(res == false);
        res = isOverflow(new byte[]{100, 28, -5, -10, -100, -100});
        System.out.println(res == false);
        res = isOverflow(new byte[]{-100, -27, 100, 28, -27, -100, -1});
        System.out.println(res == false);
        res = isOverflow(new byte[]{100, 28, -100, -27, 28, 100, 1});
        System.out.println(res == false);
        res = isOverflow(new byte[]{100, 28, -100, -27, -1});
        System.out.println(res == false);
        res = isOverflow(new byte[]{-100, -27, 100, 27, 1, 1});
        System.out.println(res == false);
        res = isOverflow(new byte[]{-100, -27, -100, -27, -1, -1});
//        res = isOutOfBounds(new int[]{-128});
//        System.out.println(res == false);
//        res = isOutOfBounds(new int[]{129});
//        System.out.println(res == false);
//        res = isOutOfBounds(new int[]{1290});
//        System.out.println(res == false);
//        res = isOutOfBounds(new int[]{-1290});
//        System.out.println(res == false);
    }

    /**
     *
     * @param arr every int <= 128 && >= -127
     * @return
     */
    public static boolean isOverflow(byte[] arr) {
//        return isOutOfBounds(arr, -127, 128);
        Stream.of(arr).forEach(System.out::print);
        int max = 128;
        int min = -127;
        byte sum = 0;
        for (byte a: arr) {
            sum += a;
//            if (sum > 0 && a > 0) {
//
//            }
        }
        System.out.println(sum);
        return true;
    }
    public static boolean isOverflow(int[] arr) {
        Stream.of(arr).forEach(System.out::print);
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int sum = 0;
        for (int a: arr) {
            sum += a;
        }
        System.out.println(sum);
        return true;
    }
    public static boolean isOverflow(long[] arr) {
        Stream.of(arr).forEach(System.out::print);
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        long sum = 0;
        for (long a: arr) {
            sum += a;
        }
        System.out.println(sum);
        return true;
    }
//    public static boolean isOutOfBounds(int[] arr, int min, int max) {
//    }
}
//[-494,-487,-471,-470,-465,-462,-447,-445,-441,-432,-429,-422,-406,-398,-397,-364,-344,-333,-328,-307,-302,-293,-291,-279,-269,-269,-268,-254,-198,-181,-134,-127,-115,-112,-96,-94,-89,-58,-58,-58,-44,-2,-1,43,89,92,100,101,106,106,110,116,143,156,168,173,192,231,248,256,281,316,321,327,346,352,353,355,358,365,371,410,413,414,447,473,473,475,476,481,491,498]
//        8511

//
//    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//        0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//            nums[a] + nums[b] + nums[c] + nums[d] == target
//
//            你可以按 任意顺序 返回答案 。
//
//
//
//            示例 1：
//
//            输入：nums = [1,0,-1,0,-2,2], target = 0
//            输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//            示例 2：
//
//            输入：nums = [2,2,2,2,2], target = 8
//            输出：[[2,2,2,2]]
///[1000000000,1000000000,1000000000,1000000000]
//        -294967296
//        /
//
//
//            提示：
//
//            1 <= nums.length <= 200
//            -109 <= nums[i] <= 109
//            -109 <= target <= 109
//
//            来源：力扣（LeetCode）
//            链接：https://leetcode.cn/problems/4sum
//            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。