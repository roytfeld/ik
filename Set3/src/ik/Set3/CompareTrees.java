package ik.Set3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CompareTrees {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n1 = Integer.parseInt(scan.nextLine().trim());
            int n2 = Integer.parseInt(scan.nextLine().trim());
            Node<Integer> node1 = new Node<Integer>(n1);
            Node<Integer> node2 = new Node<Integer>(n2);
            CompareTrees instance = new CompareTrees();
            boolean res = instance.processNode(node1, node2);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public boolean processNode(Node node1, Node node2) {
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
    }

    public void printNode(Node node)
    {
    }
}
