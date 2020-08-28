package com.self.gs.trees;
import java.util.*;
public class SmallestStringStartingFromLeaf988 {

	/*
	 a=0 . b=1 ,, z= 25
	           a
	        b     c
	      d   e  d  e
	 */
	
	 static String minStr="~";
	  
	 public static String smallestFromLeaf(TreeNode root) {
		 if(root==null)
		  return "";
		 
		 minStr="~";
		 
		 Map<Integer,Character> mapper = new HashMap<Integer,Character>();
		 for(int i=0; i < 26; i++) {
			 char ch = (char)('a'+i);
			 mapper.put(i, ch);
		 }
		 
		 findSmall(root,mapper,"");  
		 
		 return minStr;
	    }
	 
	 private static void findSmall(TreeNode node, Map<Integer,Character> mapper , String str) {
		  if(node == null) {
			  return;
		  }
		  if(node.left == null && node.right==null) {
			  str = mapper.get(node.val)+str ;
			  System.err.println(str + "," + minStr);
			if(str.compareTo(minStr)<0)  {
				minStr = str;
			}
		  }
		  System.err.println("working on left");
		  findSmall(node.left,mapper,mapper.get(node.val)+str);
		 // System.err.println("working on right " + str);
		  findSmall(node.right,mapper,mapper.get(node.val)+str);

	 }
	 
	
	 
	public static void main(String}] args) {
		
		String str = "0,1,2,3,4,3,4"; 
		TreeNode node = SerializeandDeserializeBinaryTree297.deserialize(str);
		System.err.println("o/p :" + smallestFromLeaf(node));
		
		str = "25,1,3,1,3,0,2"; 
	    node = SerializeandDeserializeBinaryTree297.deserialize(str);
		//System.err.println("o/p :" +smallestFromLeaf(node));
		

	}

	 

}
