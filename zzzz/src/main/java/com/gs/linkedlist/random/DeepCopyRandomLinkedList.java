package com.gs.linkedlist.random;

import java.util.LinkedHashMap;
import java.util.Map;
/*
 * Time : O(n)
 * Space : O(n) . hashmap 
 */
public class DeepCopyRandomLinkedList {
	
	private static RandomNode deepCopy(RandomNode head) {
		if(head == null) return head;	
		Map<Integer, RandomNode> holder = buildDetachedNodeByValueMap(head);
		RandomNode current = head;
		while(current != null){
			int val = current.val;
			RandomNode node = holder.get(val);
			node.next = (current.next != null)? holder.get(current.next.val): null;
			node.random = (current.random != null)? holder.get(current.random.val): null;
			current = current.next;
		}
		//GET FIRST ENTRY IN LINKED HASHMAP
		Map.Entry<Integer, RandomNode> firstEntry = holder.entrySet().iterator().next();
		/*
		Map.Entry<Integer, Node> lastEntry =  (Entry<Integer, Node>) holder.entrySet().toArray()[holder.size() -1];
		System.out.println("last " + lastEntry.getValue().val);
		*/
		return firstEntry.getValue();
	}

	private static Map<Integer, RandomNode> buildDetachedNodeByValueMap(RandomNode head) {
		RandomNode current = head;
		Map<Integer, RandomNode> holder = new LinkedHashMap<Integer, RandomNode>();
		while(current != null){
			int val = current.val;
			RandomNode node = new RandomNode(val);
			holder.put(val, node);
			current = current.next;
		}
		return holder;
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
