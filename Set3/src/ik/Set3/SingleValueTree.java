package ik.Set3;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SingleValueTree {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int count;

    public static void main(String[] args) throws IOException {
        TreeNode root = TreeNode.readBinaryTree();
        count = 0;
        int result = findSingleValueTrees(root);
        bw.write(Integer.toString(result));
        bw.close();
    }

    public static int findSingleValueTrees(TreeNode root) {
        checkSingleValue(root);
        return count;
    }

    public static boolean checkSingleValue(TreeNode node){

        if (node == null) { //null case
            return true;
        }
        int leftValue = (node.left_ptr != null) ? node.left_ptr.val : node.val;
        int rightValue = (node.right_ptr != null) ? node.right_ptr.val : node.val;
        boolean isLeftSingleValue = checkSingleValue(node.left_ptr);
        boolean isRightSingleValue = checkSingleValue(node.right_ptr);
        if (isLeftSingleValue && isRightSingleValue) {//will work for null cases as vell
            if (node.val == leftValue && node.val == rightValue) {
                count++;
                return true;
            }
        }
        return false;
    }
}
