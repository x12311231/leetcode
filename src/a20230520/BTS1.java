package a20230520;

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

    public static void main(String[] args) {
        TreeNode1 treeNode = (new TreeNode1()).init(Arrays.asList(1,4,3,2,4,2,5,null,null,null,null,null,null,4,6));
        BTS1 bts = new BTS1();
        int res = bts.maxSumBST(treeNode);
        System.out.println(res);
    }
}


//作者：LeetCode-Solution
//        链接：https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/solution/er-cha-sou-suo-zi-shu-de-zui-da-jian-zhi-lii4/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
