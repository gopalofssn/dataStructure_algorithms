package com.gs.linkedlist.random;

/*
 * Time : O(n)
 * Space : O(1) . no hashmap, pointer connection 
 *                and odd and even split  
 */
public class DeepCopyRandomLinkedListO1Space {
	
	private RandomNode deepCopy(RandomNode head) {
		if(head == null) return head;
		createNodeAndAttachAsNext(head);
		//System.out.println("after create next node " + head);
		hookWithRandomNode(head);
		//System.out.println("after assign random node " + head);
		return pickEvenNodes(head);
	}

	// create next node as dup and attach as next , NOT HOOKED RANDOM YET
	private void createNodeAndAttachAsNext(RandomNode node) {
		while(node != null){
			RandomNode newNextNode = new RandomNode(node.val, true);
			RandomNode nodeNext = node.next;
			node.next = newNextNode;
			newNextNode.next = nodeNext;
			node = nodeNext;
		}
	}

	private void hookWithRandomNode(RandomNode node) {
		while(node != null){
			System.err.println(node.next.val);
			node.next.random = (node.random != null) ? node.random.next : null;
			node = node.next.next;
		}
	}
	
	private RandomNode pickEvenNodes(RandomNode head) {
		RandomNode odd = head;
		RandomNode even = head.next;
		RandomNode evenHead = even;
		while(odd != null && even != null){
			odd.next = (even != null)? even.next : null;
			odd = odd.next;
			even.next = (odd != null)? odd.next : null;
			even = even.next;
		}
		
		return evenHead;
	}

	public static void main(String[] args) {
		//testCase1();
		testCase2();
	}

	private static void testCase2() {
		RandomNode node1 = new RandomNode(7);
		RandomNode node2 = new RandomNode(13);
		RandomNode node3 = new RandomNode(11);
		RandomNode node4 = new RandomNode(10);
		RandomNode node5 = new RandomNode(1);
		node1.next = node2;
		node1.random = null;
		node2.next = node3;
		node2.random = node1;
		node3.next = node4;
		node3.random = node5;
		node4.next = node5;
		node4.random = node3;
		node5.next = null;
		node5.random = node1;
		RandomNode head = node1;
		System.out.println( " Original List " + head);
		System.out.println( " DeepCopy List " + new DeepCopyRandomLinkedListO1Space().deepCopy(head));
	}

	private static void testCase1() {
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
		System.out.println( " DeepCopy List " + new DeepCopyRandomLinkedListO1Space().deepCopy(head));
	}
}
