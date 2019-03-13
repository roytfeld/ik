package ik.Set3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class KthLargest {

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
                KthLargest instance = new KthLargest();
                int res = instance.processNode(node, n);
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

    public int processNode(Node node, int k) {
        if (node == null) {
            return -1;
        }
        int val = processNode(node.right, k);
        if (val == -1) {
            //found the rightmost node
            k--;
            if (k == 0) {
                return (int) node.getData();
            }
        }
        return processNode(node.left, k);
    }

    public void printNode(Node node)
    {
    }
}
