package com.gs.linkedlist;

public class LinkedListReverseEvanNumbers {

  private static Node reverse(Node head) {
	if(head == null) return head;
	Node current = head;
	Node prev = null;
	while(current != null){
		if(isEven(current.val)){
			Node tmp = reverseUtils(current);
			if (prev == null ) head = tmp;
			else prev.next = tmp;
		}
		prev = current;
		current = current.next;
	}
	return head;
  }

  private static Node reverseUtils(Node node) { // 2->8 ....
	Node prev = null;
	Node current = node;
	while(current != null && isEven(current.val)){
		Node next = current.next;
		current.next = prev;
		prev = current; //  8 -> 2 -> null
		current = next; // 9 -> 12  ->16 ->17
	}
	node.next = current; // because node is still pointing 2
	System.out.println("REV : " + prev);
	return prev;
  }

  private static boolean isEven(int num){
	  return ( (num & 1) == 0 );
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 2, 8, 9, 12, 16, 17};
    Node head = LinkedListBuilder.build(nums);
    System.out.println("HEAD : " + head);
    head = reverse(head);
    System.out.println("Modified " + head);
    
    int[] expectedNum = {1, 8, 2, 9, 16, 12, 17};
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
