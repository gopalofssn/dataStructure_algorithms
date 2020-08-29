package com.gs.self.dfs;

import java.util.*;

public class PseudoPalindromic {
  
  private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        @SuppressWarnings("unused")
        private TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public boolean isLeaf() {
          return (this.left == null && this.right == null);
        }
        
        public String toString() {
          return String.valueOf(this.val);
        }
    }
/*
    2
  3    1
3   1    1
*/
  public int pseudoPalindromicPaths (TreeNode root) {
    if(root == null){
        return 0;
    }
    
    int count = 0;
    Stack<TreeNode> stack = new Stack<TreeNode>();  // Iterative traversal leaf to root
    Map<TreeNode, TreeNode > childParentMap = new HashMap<TreeNode, TreeNode>(); 
    stack.add(root);
    childParentMap.put(root, null);
    
    while(!stack.isEmpty()){
        TreeNode node = stack.pop();
   
        if(node.left == null && node.right == null){
          System.err.println("Stack " + stack + " node " + node.val);
          System.err.println("childParentMap " + childParentMap);
            count += hasPalindromic(node, childParentMap);
        }
        
        if(node.left != null){
            stack.add(node.left);
            childParentMap.put(node.left, node);
        }
        
        if(node.right != null){
            stack.add(node.right);
            childParentMap.put(node.right, node);
        }
    }
    
    
    PriorityQueue pq = new PriorityQueue(childParentMap);
  return count;  
    
}

// leaf to root traversal & check palindromic
private int hasPalindromic(TreeNode node, Map<TreeNode, TreeNode> childParentMap){
    Map<Integer, Integer> numberAndCountsMap = new HashMap<Integer, Integer>();
    while(node != null){ // untill reach root's parent ,  line # 25 , we set root parent as null
        numberAndCountsMap.merge(node.val, 1, (a, b) -> a + b);
        node = childParentMap.get(node);
    }  
    return hasPalindromic(numberAndCountsMap);
}

private int hasPalindromic(Map<Integer, Integer> numberAndCountsMap){
     
    boolean foundOddElement = false;
    for(Integer val : numberAndCountsMap.values()){
        if(val % 2 != 0){
            if(foundOddElement){
                return 0;
            }
            foundOddElement = true;
        }
    }
    
    return 1;
}

  public static void main(String}] args) {
    
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(3);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(1);
      
      root.right = new TreeNode(1);
      root.right.right = new TreeNode(1);
      
      //System.err.println(root.toString());
      
      System.err.println("o/p -  " + new PseudoPalindromic().pseudoPalindromicPaths(root));
      
  }
}
