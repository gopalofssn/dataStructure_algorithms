package TreeIterator;

import java.util.*;

public class BSTIteratorWithPrevVisitOption implements Iterator<BinaryTree>{

  Stack<BinaryTree> stack = new Stack<BinaryTree>();
  Deque<BinaryTree> previous_stack = new ArrayDeque<BinaryTree>();
  
  int k;
  
  public BSTIteratorWithPrevVisitOption(BinaryTree root, int k) {
    this.k = k; 
    doLeftStack(root);
  }
  
  private void doLeftStack(BinaryTree node) {
    if(node == null) return;
    stack.push(node);
    doLeftStack(node.left);
  }
  
  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public BinaryTree next() {
    BinaryTree node = stack.pop();
    doLeftStack(node.right);
    
    BinaryTree prev; 
    if(node.left != null && node.left.right != null) prev = node.left.right;
    else prev = node.left;
    
    if(prev != null)
    previous_stack.push(prev);
    
    while(previous_stack.size() > k) {
      previous_stack.removeFirst();
    }
    
    return node;
  }
  
    public boolean hasPrev() {
      return !previous_stack.isEmpty();
    }
    
    public BinaryTree prev() {
      if(!hasPrev()) {
        return null;
      }
      return previous_stack.pop();
    }
    
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
