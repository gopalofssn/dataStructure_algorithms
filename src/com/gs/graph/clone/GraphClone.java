package com.gs.graph.clone;

import java.util.*;

public class GraphClone {

	public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> nodeByVal = new HashMap<Integer, Node>();
        Set<Integer> exploredOrAddedToExplore = new HashSet<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        exploredOrAddedToExplore.add(node.val);
        Node deepCopy = createNodeAndAddToMap(node, nodeByVal);
        
        while(!queue.isEmpty()){
        	 System.out.println("queue " + queue);
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                Node current = queue.poll();
                Node currentDeepCopy = nodeByVal.get(current.val);
                for(Node neighbor : current.neighbors){
                    if(!nodeByVal.containsKey(neighbor.val)){
                        Node tmp = new Node(neighbor.val);
                        nodeByVal.put(neighbor.val, tmp);
                    }
                    Node neighborDeepCopy = nodeByVal.get(neighbor.val);
                    currentDeepCopy.neighbors.add(neighborDeepCopy); 
                    if(!exploredOrAddedToExplore.contains(neighbor.val) ){
                    	queue.offer(neighbor);
                    	exploredOrAddedToExplore.add(neighbor.val); 
                    }
                   
                }
               
            }
        }
        
        System.err.println(nodeByVal);
        return deepCopy;
    }

	private Node createNodeAndAddToMap(Node node, Map<Integer, Node> nodeByVal) {
		int val = node.val;
        Node deepCopy = new Node(val);
        nodeByVal.put(val, deepCopy);
		return deepCopy;
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
		
		Queue<Node> queue = new LinkedList<Node>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.offer(clone);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0 ; i < sz; i++) {
				Node current = queue.poll();
				for(Node neighbor : current.neighbors) {
		    		if(!visited.contains(neighbor.val)) queue.add(neighbor);
		    	}
				System.out.println("visited " + current);
				visited.add(current.val);
			}
			
		}
	}

}
