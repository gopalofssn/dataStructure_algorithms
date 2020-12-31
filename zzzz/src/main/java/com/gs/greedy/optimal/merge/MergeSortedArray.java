package com.gs.greedy.optimal.merge;

import java.util.Arrays;

public class MergeSortedArray {

	public static int[] merge(int[] nums1, int[] nums2) {
		if(isNullOrEmpty(nums1) && isNullOrEmpty(nums2)){
			return new int[0];
		}else if(isNullOrEmpty(nums1)){
			return nums2;
		}else if(isNullOrEmpty(nums2)){
			return nums1;
		}else{
			return mergeHelper(nums1, nums2);
		}
	}
	
	private static int[] mergeHelper(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] result = new int[len1 + len2];
		int n1 = 0;
		int n2 = 0;
		int index = 0;
		while(index < result.length){
			int num1 = (n1 < len1) ? nums1[n1] : Integer.MAX_VALUE;
			int num2 = (n2 < len2) ? nums2[n2] : Integer.MAX_VALUE;
			if(num1 < num2){
				result[index] = num1;
				n1++;
			}else{
				result[index] = num2;
				n2++;
			}
			index++;
		}
		return result;
	}

	private static boolean isNullOrEmpty(int[] nums) {
		return (nums == null || nums.length == 0);
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 6, 8, 10};
		int[] nums2 = { 0, 3, 7, 9, 11};
		int[] merge = merge(nums1, nums2);
		System.out.println(Arrays.toString(merge));
	}
}
