package com.self.gs.iterators;

import java.util.Stack;

public class PreOrderIterator {

  
  // root left right
  private static void recurssive(BinaryTree node) {
    if(node == null) {
      return;
    }
    System.err.println(node.val);
    recurssive(node.left);
    iterative(node.right);
    
  }
  
  
  private static void iterative(BinaryTree node) {
     
    Stack<BinaryTree> stack = new Stack<BinaryTree>();
    
    while(true) {
      
    }
    
  }
  
  
  public static void main(String}] args) {
    BinaryTree root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.right = new BinaryTree(3);
    
    recurssive(root);
    iterative(root);
    
  }

  

 
}
