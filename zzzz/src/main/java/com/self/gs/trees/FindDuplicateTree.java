package com.self.gs.trees;

import java.util.*;

public class FindDuplicateTree {

  /*
       2
   1      3
 3  n   1
 
   */
  public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Set<TreeNode> result = new HashSet<TreeNode>();
    Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    postOrder(root, map, result);
    System.err.println(map);
    return new ArrayList<TreeNode>(result);
}
private static String postOrder(TreeNode node, Map<String, Integer> map, Set<TreeNode> result){
    if(node == null){
        return "";
    }
    String serial = node.val + postOrder(node.left, map, result) + postOrder(node.right, map, result);
    if(map.getOrDefault(serial, 0) == 1){
        result.add(node);
    }
    map.compute(serial, (k,v) -> (v == null) ? 1 : v + 1);
    //map.put(serial, map.getOrDefault(serial, 0) + 1);
    return serial;
}
  public static void main(String}] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    
    root.left.left = new TreeNode(3);
    root.right.left = new TreeNode(1);
    
    
    System.err.println(findDuplicateSubtrees(root));
    
  }

}
