package com.self.gs.trees;
import java.util.*;

import com.self.gs.utils.PreetyPrint;

/*
                  5{29}
                /    \
            {6}2     -3{18}
              / \      / \
          {3}2 {1}1 {3}3   3{18}
            / \           /  \
        {1}1   0{0}      7{7} 8{8}
              / \
         {-3}-3 {3}3
         
 {sum of subtree} = node val + node left val + node right val
 
 sum of subtree [29,6,18,3,1,3,18,1,0,7,8,-3,3] 
 
 finally,
    3 presents 3 times
    1,18 presents 2 times
    others present only once 
    
  o /p - highest present is 3 , 3 is answer 

 */
   // post order traversal L R N , DFS algorithm , recursion
public class MostFrequentSubtreeSum508 {
	              
	static HashMap<Integer,Integer> holder = new HashMap<Integer,Integer>();
	static int max = Integer.MIN_VALUE;
	static HashMap<Integer,Integer>  maxOnlyHolder = new HashMap<Integer,Integer>();
	
    public static int dfs(TreeNode node) {
        if(node == null)
        	return 0;
        int sum = dfs(node.left) + dfs(node.right) + node.data;
        System.out.println("node.data " + node.data + " & its bubble up sum " + sum);
        
        if(holder.containsKey(sum)) {
        	int incrementer = holder.get(sum)+1;
        	holder.put(sum, incrementer);
        	if(incrementer == max) {
        		max = incrementer;	
        		maxOnlyHolder.put(sum, max);
        	}if(incrementer>max) {
        		max = incrementer;	
        		maxOnlyHolder.clear();
        		maxOnlyHolder.put(sum, max);
        	}
        }else {
        	holder.put(sum, 1);
        }
        return sum;
          
    }
	
  
	public static void main(String[] args) {
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
		dfs(node);
		System.out.println(holder);
		
		for(Integer s:maxOnlyHolder.keySet())
		  System.out.println(maxOnlyHolder.get(s));
	}
}
