package com.gs.self.greedy.huffmancoding;


public class Node implements Comparable<Node>{
  char ch;
  int frequency;
  Node left;
  Node right;
  
  public Node(char ch, int frequency, Node left, Node right) {
    this.ch = ch;
    this.frequency = frequency;
    this.left = left;
    this.right = right;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }
  @Override
  public int compareTo(Node that) {
     int frequencyComparator = Integer.compare(this.frequency, that.frequency);
     if(frequencyComparator != 0) {
       return frequencyComparator;
     }
     return Character.compare(this.ch, that.ch);
  }
  
}