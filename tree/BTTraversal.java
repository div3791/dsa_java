package tree;

import java.util.*;

public class BTTraversal {

    /*
     * Recursive traversals
     */

    public ArrayList<Integer> preOrder(Node<Integer> root, ArrayList<Integer> result) {
        if (root == null)
            return result;
        result.add(root.data);
        preOrder(root.left, result);
        preOrder(root.right, result);
        return result;
    }

    public ArrayList<Integer> postOrder(Node<Integer> root, ArrayList<Integer> result) {
        if (root == null)
            return result;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.data);
        return result;
    }

    public ArrayList<Integer> inOrder(Node<Integer> root, ArrayList<Integer> result) {
        if (root == null)
            return result;
        inOrder(root.left, result);
        result.add(root.data);
        inOrder(root.right, result);
        return result;
    }

    /* ---------------------------------- */

    public ArrayList<Integer> levelOrder(Node<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<Integer> item = queue.peek();
            queue.remove();
            result.add(item.data);
            if (item.left != null)
                queue.add(item.left);

            if (item.right != null)
                queue.add(item.right);
        }

        return result;
    }

    /* Iterative traversals */
    public ArrayList<Integer> preOrder(Node<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<Integer> node = stack.peek();
            result.add(node.data);
            stack.pop();

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return result;
    }

    public ArrayList<Integer> inOrder(Node<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;

            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                result.add(node.data);
                node = node.right;
            }
        }
        return result;
    }

}
