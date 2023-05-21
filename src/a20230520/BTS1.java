package a20230520;

import java.io.IOException;
import java.util.Arrays;

class BTS1 {
    static final int INF = 0x3f3f3f3f;
    int res;

    class SubTree {
        boolean isBST;
        int minValue;
        int maxValue;
        int sumValue;

        SubTree(boolean isBST, int minValue, int maxValue, int sumValue) {
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sumValue = sumValue;
        }
    }

    public int maxSumBST(TreeNode1 root) {
        res = 0;
        dfs(root);
        return res;
    }

    public SubTree dfs(TreeNode1 root) {
        if (root != null && root.val == 1) {
            System.out.println();
        }
        if (root == null) {
            return new SubTree(true, INF, -INF, 0);
        }
        SubTree left = dfs(root.left);
        SubTree right = dfs(root.right);

//        if (root.val == null) {
//            System.out.println(root.val);
//        }
        if (left.isBST && right.isBST && root.val > left.maxValue && root.val < right.minValue) {
            int sum = root.val + left.sumValue + right.sumValue;
            res = Math.max(res, sum);
            return new SubTree(true, Math.min(left.minValue, root.val), Math.max(root.val, right.maxValue), sum);
        } else {
            return new SubTree(false, 0, 0, 0);
        }
    }

    public static void main(String[] args) throws IOException {        int res;
        BTS1 bts = new BTS1();
        Integer[] list = Resource1.get();
        TreeNode1 treeNode = (new TreeNode1()).init(Arrays.asList(list));


//        for (Integer i : candiesCount) {
//            System.out.println(i);
//        }

        treeNode = (new TreeNode1()).init(Arrays.asList(1,4,3,2,4,2,5,null,null,null,null,null,null,4,6));
        res = bts.maxSumBST(treeNode);
        assert res == 20;
        treeNode = (new TreeNode1()).init(Arrays.asList(4,8,null,6,1,9,null,-5,4,null,null,null,-3,null,10));
        res = bts.maxSumBST(treeNode);
        assert res == 14;
        treeNode = (new TreeNode1()).init(Arrays.asList(8594,null,2,null,100));
        res = bts.maxSumBST(treeNode);
        assert res == 102;
        treeNode = (new TreeNode1()).init(Arrays.asList(8594,null,2,null,-100,null,-99,null,-98,null,-97,null,-96,null,-95,null,-94,null,-93,null,-92,null,-91,null,-90,null,-89,null,-88,null,-87,null,-86,null,-85,null,-84,null,-83,null,-82,null,-81,null,-80,null,-79,null,-78,null,-77,null,-76,null,-75,null,-74,null,-73,null,-72,null,-71,null,-70,null,-69,null,-68,null,-67,null,-66,null,-65,null,-64,null,-63,null,-62,null,-61,null,-60,null,-59,null,-58,null,-57,null,-56,null,-55,null,-54,null,-53,null,-52,null,-51,null,-50,null,-49,null,-48,null,-47,null,-46,null,-45,null,-44,null,-43,null,-42,null,-41,null,-40,null,-39,null,-38,null,-37,null,-36,null,-35,null,-34,null,-33,null,-32,null,-31,null,-30,null,-29,null,-28,null,-27,null,-26,null,-25,null,-24,null,-23,null,-22,null,-21,null,-20,null,-19,null,-18,null,-17,null,-16,null,-15,null,-14,null,-13,null,-12,null,-11,null,-10,null,-9,null,-8,null,-7,null,-6,null,-5,null,-4,null,-3,null,-2,null,-1,null,0,null,1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9,null,10,null,11,null,12,null,13,null,14,null,15,null,1006));
        res = bts.maxSumBST(treeNode);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(res);
    }
}


//作者：LeetCode-Solution
//        链接：https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/solution/er-cha-sou-suo-zi-shu-de-zui-da-jian-zhi-lii4/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
