package com.gs.greedy.optimal.merge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeSortedArraysOfArrays {
     
	int mergeCost = 0;
	private int[] mergeArrayNormal(int[][] sortedList) {
		mergeCost = 0;
		int[] prev = sortedList[0];
		for(int i = 1; i < sortedList.length; i++){
			int[] nums1 = prev;
			int[] nums2 = sortedList[i];
			int[] mergeArray = MergeSortedArray.merge(nums1, nums2);
			mergeCost += mergeArray.length;
			prev = mergeArray;
		}
		return prev;
	}
	
	private int[] mergeArrayOptimal(int[][] sortedList) {
		mergeCost = 0;
		Comparator<int[]> cmp = (a, b) -> (a.length - b.length);
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(cmp);
		for(int[] lst : sortedList){
			minHeap.offer(lst);
		}
		while(minHeap.size() >= 2){
			int[] nums1 = minHeap.poll();
			int[] nums2 = minHeap.poll();
			int[] mergeArray = MergeSortedArray.merge(nums1, nums2);
			mergeCost += mergeArray.length;
			minHeap.offer(mergeArray);
		}
		return minHeap.poll();
	}
	
    public static void main(String[] args) {
      int[][] sortedList = {
          { 1,  2, 3, 4, 5, 6},
          { 7, 8, 9, 10, 11 },
          { 12, 13, 14},
          { 15, 16 }
       };
      MergeSortedArraysOfArrays c = new MergeSortedArraysOfArrays(); 
      int[] merge = c.mergeArrayNormal(sortedList);
      System.out.println("Normal Merge" + Arrays.toString(merge));
      System.out.println("Normal Merge Cost " + c.mergeCost);
      
      merge = c.mergeArrayOptimal(sortedList);
      System.out.println("Optimal Merge" + Arrays.toString(merge));
      System.out.println("Optimal Merge Cost " + c.mergeCost);
        
    }


     
}
