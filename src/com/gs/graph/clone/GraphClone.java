package com.gs.graph.clone;

import java.util.*;

public class GraphClone {

	public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        map.put(node.val, new Node(node.val));
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                Node current = queue.poll();
                for(Node neighbor : current.neighbors){
                  if(!map.containsKey(neighbor.val)) {
                	 map.put(neighbor.val, new Node(neighbor.val));
                	 queue.offer(neighbor);
                  }
                  map.get(current.val).neighbors.add(map.get(neighbor.val));
                }
               
            }
        }
        
        return map.get(node.val);
    }

	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		Node clone = new GraphClone().cloneGraph(node1);
	    print("ORIGINAL " , node1);
		print("CLONE " , clone);
	}


	private static void print(String label, Node node) {
		System.out.println("*****" + label + "****");
		Queue<Node> queue = new LinkedList<Node>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.offer(node);
		visited.add(node.val);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0 ; i < sz; i++) {
				Node current = queue.poll();
				System.out.println(current);
				for(Node neighbor : current.neighbors) {
		    		if(!visited.contains(neighbor.val)) {
		    			queue.add(neighbor);
		    			visited.add(neighbor.val);
		    		}
		    	}				
			}
			
		}
		System.out.println("************");
	}

}
