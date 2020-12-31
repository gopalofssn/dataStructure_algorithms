package com.self.gs.digits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {

	static int[] findDuplicates(int[] arr1, int[] arr2) {
	    if(isNullOrEmpty(arr1) ||  isNullOrEmpty(arr2)) return new int[0];
	    
	    List<Integer> duplicateList = new ArrayList<Integer>();
	    int a1 = 0;
	    int a2 = 0;
	    while(a1 < arr1.length && a2 < arr2.length){
	      int a1SearchRange = arr1.length - a1;
	      int a2SearchRange = arr2.length - a2;
	      if(a1SearchRange < a2SearchRange){
	        int target = arr2[a2];
	        int tmp = binarySearch(arr1, a1, target);
	        if(tmp != -1){
	          duplicateList.add(target);
	          a1 = tmp;
	        }
	        a1++;
	      }else{
	        int target = arr1[a1];
	        int tmp = binarySearch(arr2, a2, target);
	        if(tmp != -1){
	          duplicateList.add(target);
	          a2 = tmp;
	        }
	        a2++;
	      }
	    }
	    
	    return convertListToArray(duplicateList);
	    }

	    private static int[] convertListToArray(List<Integer> duplicateList){
	      if(duplicateList == null || duplicateList.size() == 0) return new int[0];
	      
	      int[] duplicate = new int[duplicateList.size()];
	      int counter = 0;
	      for(int num : duplicateList){
	          duplicate[counter++] = num;
	      }
	      return duplicate;
	    }
	  
	    private static boolean isNullOrEmpty(int[] nums){
	      return (nums == null || nums.length == 0);
	    }
	  
	    private static int binarySearch(int[] nums, int left, int target){
	       int right = nums.length - 1;
	       while(left <= right){
	         int mid = left + ( (right - left) >> 1);
	         if(target == nums[mid]){
	           return mid;
	         }else if(target < nums[mid]){
	           right = mid - 1;
	         }else{
	           left = mid + 1;
	         }
	       }
	      
	      return -1;
	    }
	  
	public static void main(String[] args) {
		System.err.println(binarySearch(new int[]{1, 2, 3, 5, 6, 7}, 0, 2));
		//System.err.println(Arrays.toString(findDuplicates(new int[]{1, 2, 3, 5, 6, 7}, new int[]{3, 6, 7, 8, 20})));

	}

}
