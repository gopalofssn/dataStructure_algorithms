package com.gs.linkedlist;

public class LinkedListReverseEvanNumbers {

  private static Node reverse(Node head) {
	return head;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 8, 9, 12, 16};
    Node head = LinkedListBuilder.build(nums);
    System.out.println("HEAD : " + head);
    head = reverse(head);
    System.out.println("Modified " + head);
    
    int[] expectedNum = {1, 8, 2, 9, 16, 12};
    Node expected = LinkedListBuilder.build(expectedNum);
    System.out.println("Expected " + expected);
    System.out.println("isSame ? " + isSame(head, expected));
  }

  private static boolean isSame(Node node1, Node node2) { 
    while(node1 !=null && node2 !=null) {
      if(node1.val != node2.val) return false;
      node1 = node1.next;
      node2 = node2.next;
    }
    return (node1 == node2);
  }


}
