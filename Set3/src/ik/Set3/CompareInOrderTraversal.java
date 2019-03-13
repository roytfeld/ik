package ik.Set3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class CompareInOrderTraversal {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n1 = Integer.parseInt(scan.nextLine().trim());
            int n2 = Integer.parseInt(scan.nextLine().trim());
            Node<Integer> node1 = new Node<Integer>(n1);
            Node<Integer> node2 = new Node<Integer>(n2);
            CompareInOrderTraversal instance = new CompareInOrderTraversal();
            //Stack<Node> stack = new Stack<>();
            //boolean res = instance.processNode(node1, node2);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public boolean processNode(Node node1, Node node2) {
        IOItr itr1 = new IOItr(node1);
        IOItr itr2 = new IOItr(node2);
        while (itr1.hasNext() && itr2.hasNext()) {
            int n1 = (int) itr1.next().getData();
            int n2 = (int) itr2.next().getData();
            if (n1 != n2) {
                return false;
            }
        }
        if (itr1.hasNext()) {
            return false;
        }
        if (itr2.hasNext()) {
            return false;
        }
        return true;

/*
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1 != null && node2 == null) {
            return false;
        }
        if ((int)node1.getData() != (int)node2.getData()) {
            return false;
        }
        return processNode(node1.left, node2.left) && processNode(node1.right, node2.right);
*/
    }

    public void IterativeInOrder(Node node, Stack<Node> stack) {
        if (node == null) {
            return;
        }
        while (node.right != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.empty()) {
            if (node != null) {
                printNode(node);
                node = node.right;
            } else {
                Node n = stack.pop();
                printNode(n);
                node = node.right;
            }
        }
    }

    public void printNode(Node node)
    {
    }

    private class IOItr {
        private Stack<Node> s;

        public IOItr(Node node) {
            s = new Stack<>();
            push_left(node);
        }

        public void push_left(Node node) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !s.empty();
        }

        public Node next() {
            if (hasNext()) {
                Node n = s.pop();
                push_left(n.right);
                return n;
            }
            return null;
        }

    }
}

