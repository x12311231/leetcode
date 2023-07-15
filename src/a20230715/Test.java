package a20230715;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        s1(new Solution());
    }

    public static void s1(C solution) {
        System.out.println(solution.getClass());
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
            System.out.println(sum == target);
        }
        System.out.println(lists.size() == expectedSize);
    }
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
//
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