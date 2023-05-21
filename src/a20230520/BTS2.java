package a20230520;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

class BTS2 {
    public int inf = (int) Math.pow(10, 4);

    public int maxSumValue = -Integer.MAX_VALUE;
    public class Bst {
        boolean isGoodTree;
        int sumValue;
        int minValue;
        int maxValue;
        Bst(boolean isGoodTree, int sumValue, int minValue, int maxValue) {
            this.isGoodTree = isGoodTree;
            this.sumValue = sumValue;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }
    public int maxSumBST(TreeNode1 root) {
        findBst(root);
        return maxSumValue;
    }
    public Bst findBst(TreeNode1 root) {
        if (root != null && root.val == -3) {
            System.out.println();
        }
        // 统一边界值处理
        if (root == null) {
            return new Bst(true, 0, inf, -inf);
        }

        Bst leftBst = findBst(root.left);
        Bst rightBst = findBst(root.right);
        if (leftBst.maxValue < root.val && root.val < rightBst.minValue && leftBst.isGoodTree && rightBst.isGoodTree) {
            System.out.printf("-%d", root.val);
            int sumValue = leftBst.sumValue + root.val + rightBst.sumValue;
            maxSumValue = Math.max(sumValue, maxSumValue);
            return new Bst(
                    true,
                    sumValue, //
                    Math.min(leftBst.minValue, root.val), // 左边的总小于当前节点的值
                    Math.max(rightBst.maxValue, root.val) // 右边的总大于当前节点值
            );
        }
        System.out.printf("--%d", root.val);
//        return new Bst(false, 0, 0, 0);
        return new Bst(
                false,
                Math.max(leftBst.sumValue, rightBst.sumValue), // 从某次不符合条件开始，只需传递子树的值即可
                Math.min(leftBst.minValue, Math.min(rightBst.minValue, root.val)), // 因为已经是false了，所以这个值对整体运行不影响, 所以记录为0也不影响
                Math.max(rightBst.maxValue, Math.max(leftBst.maxValue, root.val)) //
        );
    }

    public static void main(String[] args) throws IOException {
        int res;
        BTS2 bts = new BTS2();
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
