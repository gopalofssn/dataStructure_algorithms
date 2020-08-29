package com.self.gs.trees;

import java.util.Stack;

class Node{
  int val;
  Node left; // a.k.a prev
  Node right; // aka next
  public Node(int val) {
    this.val = val;
  }
  @Override
  public String toString() {
   
    StringBuilder sb = new StringBuilder();
    if(left !=null) {
    sb.append(left)
      .append("->");
    }
    sb.append(val);
    if(right != null) {
      sb.append("->")
        .append(right);
    }
    
    return sb.toString();
  } 
  
}


public class BSTToDoublyLinkedList {

  
  private static void coverToDoublyLL(Node root) {
     
    Node node = root;
    Stack<Node> stack = new Stack<Node>();
    
    Node head = new Node(-1);
    Node result = head;
   
    while(true) {
        while(node != null) {
          stack.push(node);
          node = node.left;
        }
        
        if(stack.isEmpty()) {
          break;
        }else {
          node = stack.pop();
          System.out.println(node.val);
          head.right = node;
          node.left = head;
          head = node;
          node = node.right;
        }
    }
    
    result = result.right;
    System.out.println("begg" + result.val);
    System.out.println("head " + head.val);
    
    head.right = result;
    result.left = head;
/*    
    result = result.right;
    doublyLLDummy.left = result;
    result.right = node;
    
*/
    

    result = result.right;
    
    while (result.val != 1) {
      System.out.println("******");
      System.out.println("prev " + result.left.val);
      System.out.println(result.val);
      System.out.println("next " + result.right.val);
      System.out.println("******");
      result = result.right;
    }
    
  }
  /*
         7
     3         15
1      4   9     20
  */
  
  public static void main(String}] args) {
    Node root = new Node(7);
    root.left = new Node(3);
    root.right = new Node(15);
    
    root.left.left = new Node(1);
    root.left.right = new Node(4);
    
    root.right.left = new Node(9);
    root.right.right = new Node(20);

    System.out.println(root);
    
    coverToDoublyLL(root);
    
    
  }

  

}
