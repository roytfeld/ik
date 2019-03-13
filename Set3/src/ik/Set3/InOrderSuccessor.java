package ik.Set3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InOrderSuccessor {

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
                List<Node> nodes = new ArrayList<>();
                InOrderSuccessor instance = new InOrderSuccessor();
                boolean res = instance.processNode(node, n, nodes);
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

    public boolean processNode(Node root, int k, List nodes) {
        if (root == null) {
            return false;
        }
        if (root.isLeaf()) {
            if (k == (int)root.getData()){
                nodes.add(root.getData());
                return true;
            }
            return false;
        }
        if (processNode(root.left, k-(int)root.getData(), nodes)) {
            nodes.add(root);
            return true;
        }
        if (processNode(root.right, k-(int)root.getData(), nodes)) {
            nodes.add(root);
            return true;
        }
        return false;
    }

    public void printNode(Node node)
    {
    }
}
