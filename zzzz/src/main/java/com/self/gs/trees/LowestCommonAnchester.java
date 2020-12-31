package com.self.gs.trees;

import java.util.*;

public class LowestCommonAnchester {
  
  

  public static void main(String}] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(6);
    root.right = new TreeNode(8);
    
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(11);
    
    root.right = new TreeNode(8);
    root.right.right = new TreeNode(13);
    
     System.out.println(root);
     
     Set<TreeNode> nums = new HashSet<TreeNode>(Arrays.asList(root.left.left , root.left.right));
    
     TreeNode lca = findLowestCommonAnchester(root, nums);
     
     System.out.println("ans " + lca.val);
    
  }

  private static TreeNode findLowestCommonAnchester(TreeNode node,  Set<TreeNode> nums) {
    
    if(nums.size() == 0) {
      return node;
    }
    
    if(node == null) {
      return null;
    }
    
    if(nums.contains(node)) {
      System.out.println("found " + node.val);
      nums.remove(node);
      return node;
    }
    
    System.out.println("checking left of " + node.val);
    TreeNode left = findLowestCommonAnchester(node.left, nums);
    System.out.println("checking right of " + node.val);
    TreeNode right = findLowestCommonAnchester(node.right, nums);
    
    if(left != null && right !=null) {
      return node;
    }
    
    if(left == null && right == null ) {
      return null;
    }
    
    return left != null ? left : right;
  }
}
