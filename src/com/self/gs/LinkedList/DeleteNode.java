package com.self.gs.LinkedList;

public class DeleteNode {
	
	private static void deleteNode(Node<Integer> node, int i) {
	        while(node!=null && node.next!=null){
	            if(node.data== i){
	                  node.data = node.next.data;
	                  node.next = node.next.next;
	                break;
	            }
	            node = node.next;
	        }
	    }
	
  public static void main(String}] args) {
	  SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
		Llist.append(1);
		Llist.append(2);
		Llist.append(3);
		Llist.append(4);
		Llist.append(5);
		Llist.append(6);
		Llist.append(7);
		Llist.append(8);
		Llist.append(9);
		Llist.append(10);
		Llist.append(11);
		
		deleteNode(Llist.head,1);
		Llist.print();
}


}
