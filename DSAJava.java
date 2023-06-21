import java.util.*;

import tree.BTTraversal;
import tree.TreeNode;

public class DSAJava {
    public static void main(String[] args) {

        TreeNode l1 = new TreeNode(2, null, null);
        TreeNode l2 = new TreeNode(4, null, null);
        TreeNode l3 = new TreeNode(6, null, null);
        TreeNode r1 = new TreeNode(3, null, null);
        TreeNode r2 = new TreeNode(5, null, null);
        TreeNode r3 = new TreeNode(7, null, null);
        TreeNode root = new TreeNode(1, null, null);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;

        BTTraversal traversal = new BTTraversal();
        ArrayList<Integer> result = new ArrayList<>();

        traversal.postOrder(root, result).forEach((value) -> System.out.println(value));

    }
}
