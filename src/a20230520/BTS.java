package a20230520;


import java.util.Arrays;

//public class BTS {
//}
class BTS {
    private int ans; // 二叉搜索树可以为空

    public int maxSumBST(TreeNode1 root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode1 node) {
        if (node == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = dfs(node.left); // 递归左子树
        int[] right = dfs(node.right); // 递归右子树
        int x = node.val;
        if (x <= left[1] || x >= right[0]) // 不是二叉搜索树
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        int s = left[2] + right[2] + x; // 这棵子树的所有节点值之和
        ans = Math.max(ans, s);

        return new int[]{Math.min(left[0], x), Math.max(right[1], x), s};
    }

    public static void main(String[] args) {
        TreeNode1 treeNode = (new TreeNode1()).init(Arrays.asList(1,4,3,2,4,2,5,null,null,null,null,null,null,4,6));
        BTS bts = new BTS();
        int res = bts.maxSumBST(treeNode);
        System.out.println(res);
    }
}


//作者：endlesscheng
//        链接：https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/solution/hou-xu-bian-li-pythonjavacgo-by-endlessc-gll3/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
