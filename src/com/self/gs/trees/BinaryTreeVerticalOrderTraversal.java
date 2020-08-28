package com.self.gs.trees;

import java.util.*;
import java.util.stream.Collectors;

class NodeMeta implements Comparable<NodeMeta>{
	int x;
	int parentX;
    TreeNode treeNode;
	public NodeMeta(int _x,int _parentX, TreeNode _treeNode){
		x = _x;
		parentX = _parentX;
		treeNode = _treeNode;
	}
	@Override
	public int compareTo(NodeMeta o) {
		int thisX = Math.abs(x);
		int oX = Math.abs(o.x);
		if(this.x==o.x) {
			return (Math.abs(o.parentX)-Math.abs(this.parentX));
		}
		return (oX-thisX);
	}
}
public class BinaryTreeVerticalOrderTraversal {

	/*
	                   Y
  X -2 -1  0  1  2  |  0     
	  |  | 1 | |      -1
	  |2 |   |3|      -2
	 4|  |5 6| |7     -3
	 
	   level order traversal , and ship index from top , i,e 1's index 0 , 2's index -1 and 3's index 1
	   left index = parent index -1 
	   right index = parent index + 1
	   
	   - TreeMap to maintain <index , List<node val> >  
	 
	 */
	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		 if(root==null)
			 return null;
		 
		 TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
	        
		 
		 Map<Integer,List<Integer>> holder = new TreeMap<Integer, List<Integer>>();
		 PriorityQueue<NodeMeta> queue = new PriorityQueue<NodeMeta>();
		 addToQueue(queue,0,0,root);
		 while(!queue.isEmpty()) {
			 int sz = queue.size();
			 for(int i=0;i<sz;i++) {
				 NodeMeta meta = queue.poll();
				 int x=meta.x;
				 int parentX = meta.parentX;
				 TreeNode node = meta.treeNode;
				 if(holder.containsKey(x)) {
					 List<Integer> tmp = holder.get(x);
					 tmp.add(node.val);
				     holder.put(x,tmp);
				 }else {
					 holder.put(x,new ArrayList<Integer>(){{add(node.val);}}); 
				 }
				if(node.left!=null) {
					addToQueue(queue,x-1,x,node.left);
				}
				if(node.right!=null) {
					addToQueue(queue,x+1,x,node.right);
				}
			 }
		 }
		 System.err.println(holder);
		 return holder.values()
                 .stream()
                 .map(ArrayList::new)
                 .collect(Collectors.toList());
	}
	
	private static void addToQueue(PriorityQueue<NodeMeta> queue,int x, int parentX, TreeNode node) {
		queue.offer(new NodeMeta(x,parentX,node));
	}
	public static void main(String}] args) {
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		*/
		TreeNode root = SerializeandDeserializeBinaryTree297.deserialize("1,2,3,4,5,6,7");
				//SerializeandDeserializeBinaryTree297.deserialize("0,2,1,3,X,X,X,4,5,X,7,6,X,10,8,11,9");
		//BinaryTreeTraversal.LevelOrderTraversal(root);
		//System.out.println(BinaryTreeTraversal.LevelOrderTraversal(root));
		
		System.out.println(verticalTraversal(root));//("0,2,1,3,X,X,X,4,5,X,7,6,X,10,8,11,9")));
	}

	

}
