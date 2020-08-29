package com.gs.self.greedy.huffmancoding;

import java.util.*;
/*
 * Reference : https://www.youtube.com/watch?v=zSsTG3Flo-I -java
 * theory : https://www.youtube.com/watch?v=co4_ahEDCho
 */
public class HuffmanEncoder {
  
  public static EncodedResult compress(String data) {
    int}] frequencyTable = buildFrequencyTable(data);
    Node root = buildHuffmanTree(frequencyTable);
    Map<Character , List<Boolean>> lookupTable = buildLookuptable(root);
    return new EncodedResult(generateEncodedData(data, lookupTable), root);
  }
  
  
  public static String decompress(EncodedResult encodedResult) {
    StringBuilder builder = new StringBuilder();
    
    List<Boolean> encodedData = encodedResult.getEncodedData();
    Node current = encodedResult.getRoot();
    
    int i = 0;
    
    while(i < encodedData.size()) {
      
      while(!current.isLeaf()) {
        boolean bit = encodedData.get(i);
        if(!bit) {
          current = current.left;
        }else if(bit) {
          current = current.right;
        }else {
          throw new IllegalArgumentException("Invalid bit !!" + bit);
        }
        i++;
      }
      builder.append(current.ch);
      current = encodedResult.getRoot();
      
    }
    
     return builder.toString();
  }
  
  private static int}] buildFrequencyTable(String data) {
    int}] freqTable = new int}256];
    for(char ch : data.toCharArray()) {
      freqTable}ch]++;
    }
    return freqTable;
  }
  
  private static Node buildHuffmanTree(int}] frequencyTable) {
       
    PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
    
    for(char i = 0; i < frequencyTable.length; i++) {
      if(frequencyTable}i] != 0) {
         priorityQueue.offer(new Node(i,frequencyTable}i], null, null ));
      }
    }
   
    while(priorityQueue.size() > 1) {
      Node left = priorityQueue.poll();
      Node right = priorityQueue.poll();
      int frequencySum = left.frequency + right.frequency;
      Node parent = new Node('\0', frequencySum , left, right);
      priorityQueue.offer(parent);
    }
    
    return priorityQueue.poll();
  }
  
  
  private static Map<Character, List<Boolean>> buildLookuptable(Node root) {
    Map<Character, List<Boolean>> lookupTable = new HashMap<Character, List<Boolean>>();
    
    buildLookupTableHelper(root, new LinkedList<Boolean>(), lookupTable);
    
    return lookupTable;
  }
  
  private static void buildLookupTableHelper(Node node, 
                                             List<Boolean> encodedVal,
                                             Map<Character, List<Boolean>> lookupTable) {
    if(node.isLeaf()) {
      lookupTable.put(node.ch, encodedVal);
    }else {
      List<Boolean> leftEncodedVal = new LinkedList<Boolean>(encodedVal);
      leftEncodedVal.add(false);
      buildLookupTableHelper(node.left, leftEncodedVal, lookupTable);
      
      List<Boolean> rightEncodedVal = new LinkedList<Boolean>(encodedVal);
      rightEncodedVal.add(true);
      buildLookupTableHelper(node.right, rightEncodedVal, lookupTable);
    }
    
  }
  
  private static List<Boolean> generateEncodedData(String data, Map<Character, List<Boolean>> lookupTable) {
    List<Boolean> encodedData = new LinkedList<Boolean>();
    for(char ch : data.toCharArray()) {
      encodedData.addAll(lookupTable.get(ch));
    }
    return encodedData;
  }


 

}
