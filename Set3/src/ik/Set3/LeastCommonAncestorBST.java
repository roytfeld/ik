package ik.Set3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeastCommonAncestorBST {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim());
            int n1 = Integer.parseInt(scan.nextLine().trim());
            int n2 = Integer.parseInt(scan.nextLine().trim());
            Node<Integer> root = new Node<Integer>(n);
            Node<Integer> node1 = new Node<Integer>(n1);
            Node<Integer> node2 = new Node<Integer>(n2);
            LeastCommonAncestorBST instance = new LeastCommonAncestorBST();
            instance.printNode(root);
            //Stack<Node> stack = new Stack<>();
            //boolean res = instance.processNode(node1, node2);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public Node processNode(Node root, Node node1, Node node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        if ((int)root.getData()>(int)node1.getData() && (int)root.getData()>(int)node2.getData()) {
            return processNode(root.left, node1, node2);
        }
        if ((int)root.getData()<(int)node1.getData() && (int)root.getData()<(int)node2.getData()) {
            return processNode(root.right, node1, node2);
        }
        return root;
    }

    public void printNode(Node node)
    {
    }
}
