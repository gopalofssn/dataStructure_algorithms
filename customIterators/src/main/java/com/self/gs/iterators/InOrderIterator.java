package com.self.gs.iterators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class InOrderIterator implements Iterator {

  
  Stack<BinaryTree> stack = new Stack<BinaryTree>();
  
  public InOrderIterator(BinaryTree node) {
    
    populateStack(node); 
    
  }

  private void populateStack(BinaryTree node) {
    while(node != null) {
      stack.push(node);
      node = node.left;
    }
  }
 
  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public Integer next() {
    BinaryTree node = stack.pop();
    int result = node.val;
    populateStack(node.right);
    return result;
  }
  
  // L Ro Ri    1 2 3 
  public static void inorderTrversal(BinaryTree node) {
    
    Stack<BinaryTree> stack = new Stack<BinaryTree>();
    
    while(true) {
      if(node != null) {
        stack.push(node);
        node = node.left;
      }else {
        if(stack.isEmpty()) {
          break;
        }
        node = stack.pop();
        System.err.println(node.val);
        node = node.right;
      }
      
    }
    
    
  }
  
  public static void inorderTrversalRecurrsion(BinaryTree node) {
    if(node == null) {
      return;
    }
    inorderTrversalRecurrsion(node.left);
    System.err.println(node.val);
    inorderTrversalRecurrsion(node.right);
  }
  
  
  public static void main(String}] args) {
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int i = map.getOrDefault(1, 100);
    System.err.println(i);
    
    BinaryTree root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.right = new BinaryTree(3);
    
    root.left.left = new BinaryTree(21);
    root.left.right = new BinaryTree(22);
    
    root.right.left = new BinaryTree(31);
    root.right.right = new BinaryTree(32);
    
    levelOrder(root);
    customOrder(root);
    
    inorderTrversalRecurrsion(root);
    System.err.println("*****");
    inorderTrversal(root);
    
    
    System.err.println("@@@@@");
    InOrderIterator itr = new InOrderIterator(root);
    
    while(itr.hasNext()) {
      System.err.println(itr.next());
    }
    
    List<String> str = new ArrayList<String>();
    str.iterator();
    
  }

  
  private static class NodePosition{
    BinaryTree node;
    int position;
    public NodePosition(BinaryTree node, int position) {
      this.node = node;
      this.position = position;
    }
  }
  private static void customOrder(BinaryTree root) {
 
    LinkedList<NodePosition> levelQueue = new LinkedList<NodePosition>();
    levelQueue.offer(new NodePosition(root, 0));
    List<List<Integer>> levelList = new ArrayList<List<Integer>>();
    
    while(!levelQueue.isEmpty()) {
      int sz = levelQueue.size();
     
      for(int i = 0; i < sz; i++) {
        NodePosition tmp = levelQueue.poll();
        int index = tmp.position;
        BinaryTree node = tmp.node;
        
        
      }
      
    }
    
    
  }

  private static void levelOrder(BinaryTree root) {
    
    LinkedList<BinaryTree> levelQueue = new LinkedList<BinaryTree>();
    
    List<List<Integer>> levelList = new ArrayList<List<Integer>>();
    levelQueue.offer(root);
    boolean reverseFlag = false;
    while(!levelQueue.isEmpty()) {
      int sz = levelQueue.size();
      LinkedList<Integer> lst = new LinkedList<Integer>();
      
      reverseFlag = !reverseFlag;
      
      for(int i = 0; i < sz; i++) {
        BinaryTree tmp = levelQueue.poll();
        if(reverseFlag)
          lst.addLast(tmp.val);
        else
          lst.addFirst(tmp.val);
        
        if(tmp.left != null) {
  
            levelQueue.offer(tmp.left);;
            
        }
        if(tmp.right != null) {

            levelQueue.offer(tmp.right);
        }
      }
      
      levelList.add(lst);
    }
    
   
    System.err.println(levelList);
    
     
  }

}
