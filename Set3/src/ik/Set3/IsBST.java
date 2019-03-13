package ik.Set3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IsBST {

    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        TreeNode root = TreeNode.readBinaryTree();
        boolean result = isBST(root);
        bw.write(Boolean.toString(result));
        bw.close();
    }

    public static boolean isBST(TreeNode root){
        if (root == null) {
            return true;
        }
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        return processNode(root, min, max);
    }

    public static boolean processNode(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val<min || node.val>max) {
            return false;
        }
        return processNode(node.left_ptr, min, node.val) && processNode(node.right_ptr, node.val,max);
    }
}
