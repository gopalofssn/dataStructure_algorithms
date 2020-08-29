package com.gs.self.greedy.huffmancoding;

import java.util.List;

public class EncodedResult{
  private List<Boolean> encodedData;
  private Node root;
  public EncodedResult(List<Boolean> encodedData, Node node) {
    this.encodedData = encodedData;
    this.root = node;
  }
  
  public Node getRoot() {
    return this.root;
  }
  
  public List<Boolean> getEncodedData() {
    return this.encodedData;
  }
}