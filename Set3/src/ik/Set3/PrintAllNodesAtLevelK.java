package ik.Set3;

import java.io.*;
import java.util.*;

public class PrintAllNodesAtLevelK {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim());
            if (n>3 && n<13) {
                bw.write("Possible queen combinations for the board of the size "+n);
                bw.newLine();
                Node<Integer> node = new Node<Integer>(n);
                PrintAllNodesAtLevelK instance = new PrintAllNodesAtLevelK();
                instance.printLevelK(node, n);
            } else {
                bw.write("n is out of range");
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public void printLevelK(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 1) {
            printNode(root);
            return;
        }
        printLevelK(root.left, k-1);
        printLevelK(root.right, k-1);
    }

    public void printNode(Node node)
    {
    }
}
