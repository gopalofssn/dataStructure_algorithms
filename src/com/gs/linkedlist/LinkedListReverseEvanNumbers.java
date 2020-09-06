package com.gs.linkedlist;

public class LinkedListReverseEvanNumbers {
df
  private static void reverse(Node head) {
     
    Node current = head;
    Node prev = null;
    while(current != null) {
      if(isEven(current.val)) {
        Node[] reversedAndCurrent =  reverseHlper(current);
        if(prev != null) {
          prev.next = reversedAndCurrent[0];
        }
        if(reversedAndCurrent[1] != null) {
          current = reversedAndCurrent[1];
        }else {
          break;
        }
      }
      prev = current;
      current = current.next;
    }
    
  }

  
  
  private static Node[] reverseHlper(Node current) {
    
    Node reversed = null;
    Node tmp = current;
    while(current != null && isEven(current.val )) {
      Node nextCurrent = current.next;
      current.next = reversed;
      reversed = current;
      current = nextCurrent;
    }
    

    tmp.next = current;
    System.err.println("reverseHlper combined " + reversed);
    System.err.println("reverseHlper  current " + current);
    Node[] result = new Node[2];
    result[0] = reversed;
    result[0] = current;
    return result;
  }



  private static boolean isEven(int data) {
    
    return (data & 1) == 0;
  }



  public static void main(String[] args) {
    int[] nums = {1, 2, 8, 9, 12, 16};
    Node head = LinkedListBuilder.build(nums);
    System.err.println("before reverse" + head);
    
    reverse(head);
    System.err.println("after reverse " + head);
    
    int[] expectedNum = {1, 8, 2, 9, 16, 12};
    Node expectedHead = LinkedListBuilder.build(expectedNum);
    
    System.err.println("compared " + isSame(head, expectedHead));

  }



  private static boolean isSame(Node node1, Node node2) {
     
    while(node1 !=null && node2 !=null) {
      if(node1.val != node2.val)
        return false;
      
      node1 = node1.next;
      node2 = node2.next;
    }
    
    return (node1 == node2);
  }


}
