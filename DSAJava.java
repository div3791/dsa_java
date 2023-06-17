import java.util.*;

import tree.BTTraversal;
import tree.Node;
import tree.TreeHight;

public class DSAJava {
    public static void main(String[] args) {

        Node<Integer> l1 = new Node<Integer>(2, null, null);
        Node<Integer> l2 = new Node<Integer>(4, null, null);
        Node<Integer> l3 = new Node<Integer>(6, null, null);
        Node<Integer> r1 = new Node<Integer>(3, null, null);
        Node<Integer> r2 = new Node<Integer>(5, null, null);
        Node<Integer> r3 = new Node<Integer>(7, null, null);
        Node<Integer> root = new Node<Integer>(1, null, null);

        root.left = l1;
        root.right = r3;
        l1.left = r1;
        l1.right = l2;
        l2.left = r2;
        l2.right = l3;

        BTTraversal traversal = new BTTraversal();
        ArrayList<Integer> result = new ArrayList<>();

        traversal.inOrder(root).forEach((value) -> System.out.println(value));

    }
}
