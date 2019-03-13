package ik.Set3;

import java.io.*;
import java.util.*;

public class UpsideDown {

    public static void main(String[] args){
        TreeNode root = TreeNode.readBinaryTree();
        TreeNode result = flipUpsideDown(root);
        TreeNode.printBinaryTree(result);
    }

    public static TreeNode flipUpsideDown(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left_ptr == null && root.right_ptr == null) {
            return root;
        }
        TreeNode flippedNode = flipUpsideDown(root.left_ptr);
        root.left_ptr.left_ptr = root.right_ptr;
        root.left_ptr.right_ptr = root;
        root.left_ptr = null;
        root.right_ptr = null;
        return flippedNode;
    }
}
