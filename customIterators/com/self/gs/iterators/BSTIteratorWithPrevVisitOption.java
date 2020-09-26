package com.self.gs.iterators;

import java.util.*;

public class BSTIteratorWithPrevVisitOption{

  /*
          7
      3         15
  1      4   9     20
   */

  public static void main(String}] args) {
    
    BinaryTree root = new BinaryTree(7);
    root.left = new BinaryTree(3);
    root.right = new BinaryTree(15);
    
    root.left.left = new BinaryTree(1);
    //root.left.right = new BinaryTree(4);
    
    root.right.left = new BinaryTree(9);
    root.right.right = new BinaryTree(20);
    
    BSTIteratorWithPrevVisitOption itr = new BSTIteratorWithPrevVisitOption(root, 4);
    
    while(itr.hasNext()) {
      System.out.println("******");
      int val = itr.next().val;
      System.out.println("current " + val);
      
      if(val == 9) {
        System.out.println("has prev? " + itr.hasPrev());// + ", prev " + itr.prev.val );
         while(itr.hasPrev()) {
           System.out.println("prev " + itr.prev().val);
         }
      }
      System.out.println("******");
    }
    

  }


  
  
}
