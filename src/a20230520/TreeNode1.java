package a20230520;

import java.util.Iterator;
import java.util.List;

public class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    class Node {
        TreeNode1 val;
        Node next;
        Node(TreeNode1 val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
//    public TreeNode1 init(int[] aa) {
//        int i = 0;
//        TreeNode1 treeRoot = new TreeNode1(aa[i]);
//        Node head = new Node(treeRoot, null);
//        while (i + 1 < aa.length) {
//            TreeNode1 val1;
//            Node curPoint = null;
//            Node curHead = null;
//
//            do {
//                if (i + 1 >= aa.length) {
//                    break;
//                }
//                val1 = new TreeNode1(aa[++i]);
//                head.val.left = val1;
//                System.out.println("i:" + i + " val:" + val1.val);
//                if (curHead == null) {
//                    curHead = new Node(val1, null);
//                    curPoint = curHead;
//                } else {
//                    curPoint.next = new Node(val1, null);
//                    curPoint = curPoint.next;
//                }
//                if (i + 1 >= aa.length) {
//                    break;
//                }
//                val1 = new TreeNode1(aa[++i]);
//                System.out.println("i:" + i + " val:" + val1.val);
//                head.val.right = val1;
//                curPoint.next = new Node(val1, null);
//                curPoint = curPoint.next;
//                head = head.next;
//            } while (head != null && i + 1 < aa.length);
//            head = curHead;
//        }
//        return treeRoot;
//    }
    public TreeNode1 init(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        TreeNode1 treeRoot = new TreeNode1(iterator.next());
        Node head = new Node(treeRoot, null);
        while (iterator.hasNext()) {
            TreeNode1 val1;
            Node curPoint = null;
            Node curHead = null;

            do {
                Integer next = iterator.next();
                val1 = next == null ? null : new TreeNode1(next);
                if (next != null) {
                    head.val.left = val1;
                }
                if (curHead == null && val1 != null) {
                    curHead = new Node(val1, null);
                    curPoint = curHead;
                } else {
                    if (val1 != null) {
                        curPoint.next = new Node(val1, null);
                        curPoint = curPoint.next;
                    }
                }
                if (!iterator.hasNext()) {
                    break;
                }
                next = iterator.next();
                val1 = next == null ? null : new TreeNode1(next);
                if (curHead == null && val1 != null) {
                    curHead = new Node(val1, null);
                    curPoint = curHead;
                }
                if (val1 != null) {
                    head.val.right = val1;

                    curPoint.next = new Node(val1, null);
                    curPoint = curPoint.next;
                }
                head = head.next;
            } while (head != null && iterator.hasNext());
            head = curHead;
            linkPrint(head);
        }
        return treeRoot;
    }
    public static void linkPrint(Node node) {
        System.out.println("-------");
        while (node != null) {
            System.out.printf("=%d=", node.val != null ? node.val.val : null);
            node = node.next;
        }
        System.out.println();
        System.out.println("---end--");
    }
}
