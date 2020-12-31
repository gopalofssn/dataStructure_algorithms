package com.self.gs.trees;

public class PreOrderParenthesis {

  /*
         1
      2     3
        4
      5
   op:  1(2(4))(3)
   
   */
  public static String tree2str(TreeNode t) {
    if( t == null){
        return "#";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(t.val);
    
    String left = tree2str(t.left);
    if(left != "#"){
        sb.append("(" + left + ")");
    }
    
    String right = tree2str(t.right);
    if(right != "#"){
        sb.append("(" + right + ")");
    }
    
    
    return sb.toString();
}
  
 /*
  Input: "4(2(3)(1))(6(5))"
          L L L  R   R L  
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
  */
  private static TreeNode str2Tree(String str) {
    
    return helper(str, 0);
    
  }

  private static TreeNode helper(String str, int pos) {
    if(pos >= str.length())  {
      return null;
    }
    
    while(pos <str.length() && (str.charAt(pos) == '(' || str.charAt(pos) ==')')  ){
      pos++;
    }
    
    boolean isNegative = false;
    if( pos <str.length() &&  str.charAt(pos) == '-') {
      isNegative = true;
      pos++;
    }
    
    int num = 0;
    while(pos <str.length() &&  Character.isDigit(str.charAt(pos))) {
      num = (num * 10) + Character.getNumericValue(str.charAt(pos));
      pos++;
    }
    if(isNegative) {
      num = (-1) * num;
    }
    
    System.err.println(num);
    TreeNode node = new TreeNode(num);
    
    if(pos <str.length() && str.charAt(pos) == '(') {
      node.left = helper(str, pos );
    }
    
    if(pos <str.length() && str.charAt(pos) == ')') {
      node.right = helper(str, pos);
    }
   
    
    return node;
  }

  public static void main(String}] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(5);
    
    String str = tree2str(root);
    System.err.println(str);
    
    root = str2Tree("-410(2(3)(1))(6(5))");
/*
       -410
     2    
 */
    System.err.println(root);
    
    System.err.println(tree2str(root));
    
  }
  

}
