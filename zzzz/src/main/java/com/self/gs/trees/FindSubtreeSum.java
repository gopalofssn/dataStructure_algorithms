package com.self.gs.trees;
import java.util.*;

import com.self.gs.utils.PreetyPrint;

/*
                  5{4}
                /    \
            {5}2     -3{3}
              / \      / \
          {3}2 {1}1 {3}3   3{18}
            / \           /  \
        {1}1   0{0}      7{7} 8{8}
              / \
         {-3}-3 {3}3
  Analysis
  --------
    Tree sum
      | 
     / \ - o/p : }}4], }5, 3], }3, 1, 3, 18], }1, 0, 7, 8], }-3, 3]] 
               
  of which each sum present n how many times
      sum val | present
      0     	1
      1			2
      18		1
      -3		1
      3			4
      5			1
      7			1
      8			1
      
      winner 3 - because it present 4 times
        
 */
public class FindSubtreeSum {
	
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    static List<List<Map<Integer,Integer>>> treeSumresult = new ArrayList<List<Map<Integer,Integer>>>();
    static int max=1;
    static Map<Integer,Integer> maxSumDetails = new HashMap<Integer,Integer>(1);
    
    public static void findSubTreeSum(TreeNode node) {
       if(node==null) {
    	   max=0;
    	   return;
       }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(node);
       
       while(!queue.isEmpty()) {
    	   
    	   int sz = queue.size();
    	   List<Map<Integer,Integer>> levelSum = new ArrayList<Map<Integer,Integer>>();
    	   for(int i=0;i<sz;i++) {
    		   TreeNode current = queue.poll();
    		   int sum = current.val ;
    		   
    		   if(current.left!=null) {
    			   queue.add(current.left);
    			   sum += current.left.val;
    		   }
    		   if(current.right!=null) {
    			   queue.add(current.right);
    			   sum += current.right.val;
    		   }
    		   if(map.containsKey(sum)) {
    			 int temp = map.get(sum)+1;
    		     map.put(sum,temp);
    		      if(temp>max) {
    		    	  max =temp;
    		    	  maxSumDetails.clear();
    		    	  maxSumDetails.put(sum, temp);
    		      }
    		   }
    		   else
    			   map.put(sum,1);  
    		   
    		   Map<Integer,Integer> element = new HashMap<Integer,Integer>();
    		   element.put(current.val, sum);
    		   levelSum.add(element);
    	   }
    	   treeSumresult.add(levelSum);
       }  
    }
	
  
	public static void main(String}] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(2);
		node.right = new TreeNode(-3);
		
		
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(1);
		
		node.left.left.left = new TreeNode(1);
		node.left.left.right = new TreeNode(0);
		
		node.left.left.right.left = new TreeNode(-3);
		node.left.left.right.right = new TreeNode(3);
		
		
		node.right.left = new TreeNode(3);
		node.right.right = new TreeNode(3);
		
		
		node.right.right.left = new TreeNode(7);
		node.right.right.right = new TreeNode(8);
		findSubTreeSum(node);
		System.out.println("treeSumresult at each node by Level order traversal - " + treeSumresult);
		System.out.println("distinct sum & it's times-  " + map);
		System.out.println("distinct sum & highest present -  " + max);
		System.out.println("maxSumDetails - " + maxSumDetails);
		//PreetyPrint.print(findSubTreeSum(node));
		
	}
}
