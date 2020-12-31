package com.self.gs.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

}

class Edge{
	boolean isDirected = false;
	Vertex vertex1;
	Vertex vertex2;
	int weight;
	
	public Edge(Vertex v1, Vertex v2) {
		vertex1 = v1;
		vertex2 = v2;
	}
	
	public Edge(Vertex v1, Vertex v2, boolean _isDirected) {
		vertex1 = v1;
		vertex2 = v2;
		isDirected = _isDirected;
	}
	
	public Edge(Vertex v1, Vertex v2, int _weight, boolean _isDirected) {
		vertex1 = v1;
		vertex2 = v2;
		weight = _weight;
		isDirected = _isDirected;
	}
}

class Vertex{
	int val;
	List<Vertex> adjacentVertices = new ArrayList<Vertex>();
	
	public Vertex(int _val) {
		val = _val;
	}
	
	public void addVertex(Vertex _vertex) {
		adjacentVertices.add(_vertex);
	}
	
	public List<Vertex> getAdjacentVertices(){
		return adjacentVertices;
	}
}


