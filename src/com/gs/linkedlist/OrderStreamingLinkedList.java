package com.gs.linkedlist;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class OrderStreamingLinkedList {
	
	private Node head;
	private Map<Integer, Node> holder;
	public OrderStreamingLinkedList(){
		head = new Node(-1);
		holder = new TreeMap<Integer, Node>();
		holder.put(-1 , head);
	}
	
	private void insert(int num) {
		Node node = new Node(num);
		if(holder.size() == 1){
			head.next = node;
			holder.put(num, node);
			return;
		}
		Set<Integer> keys = holder.keySet();
		int postion = choosePosition(keys, num);
		System.out.println("position " + postion);
		Node current = holder.get(postion);
		System.out.println(current);
		Node next = (current.next != null) ? current.next : null;
		current.next = node;
		node.next = next;
		holder.put(num, node);
		
	}
	
	private Integer choosePosition(Set<Integer> keys, int target) {
		Integer[] nums = new Integer[keys.size()];
		keys.toArray(nums);
		return binarySearch(nums, target);
	}

	private Integer binarySearch(Integer[] nums, int target) {
		System.out.println("target " + target);
		if(nums == null) return null;
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = right - ((right - left) / 2);
			if(mid > 0 && nums[mid - 1] < target && nums[mid] > target
					|| mid == 0 && nums[mid] > target){
				System.out.println("returning pos " + mid);
				return nums[mid];
			}else if(nums[mid] < target ){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return nums[right];
	}

	private void print() {
		Node current = head.next;
		System.out.println(head);
	}
	
	public static void main(String[] args) {
		int[] numberStream = {7, 8, 4, 1, 2, 3};
		OrderStreamingLinkedList o = new OrderStreamingLinkedList();
		for(int num : numberStream){
			o.insert(num);
			o.print();
		}
	}




}
