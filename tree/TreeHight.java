package tree;

public class TreeHight {
    public int getTreeHeight(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
