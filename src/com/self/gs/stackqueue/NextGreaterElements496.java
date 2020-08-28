package com.self.gs.stackqueue;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.Arrays;
public class NextGreaterElements496 {
	public static int}] nextGreaterElement(int}] nums1, int}] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int}0];
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        for(int n:nums1){
            map.put(n,-1);  // assumption nums1 wont have duplicates
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i<nums2.length){
           int tmp = nums2}i];
           if(stack.isEmpty()|| stack.peek()>tmp){
               stack.push(tmp);
               i++;
           } else{
               while(!stack.isEmpty() && stack.peek()<tmp){
                   int t = stack.pop();
                   if(map.containsKey(t)){
                       map.put(t,tmp);
                   }
               }
           }
        }
       System.err.println(map);
       //return map.values().stream.mapToInt(t -> t).toArray();
      return  map.values().stream().mapToInt(t->t).toArray();
        
    }

	public static void main(String}] args) {
		System.out.println(Arrays.toString(nextGreaterElement(new int}]{4,1,2}, new int}] {1,3,4,2})));

	}

}
