package com.gs.linkedlist.random;

/*
 * Time : O(n)
 * Space : O(1) . no hashmap, pointer connection 
 *                and odd and even split  
 */
public class DeepCopyRandomLinkedListO1Space {
	
	private static String deepCopy(RandomNode head) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		RandomNode node1 = new RandomNode(1);
		RandomNode node2 = new RandomNode(2);
		RandomNode node3 = new RandomNode(3);
		RandomNode node4 = new RandomNode(4);
		node1.next = node2;
		node1.random = node3;
		node2.next = node3;
		node2.random = node4;
		node3.next = node4;
		node3.random = node2;
		node4.random = node1;
		
		RandomNode head = node1;
		System.out.println( " Original List " + head);
		System.out.println( " DeepCopy List " + deepCopy(head));
	}
}
