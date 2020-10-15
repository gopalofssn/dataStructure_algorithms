package com.gs.stack;

import java.util.*;

public class NumbersOfAtoms {

  

    /*
    flatten : K4(ON(SO3)2)2 - > K4(ON SO3 SO3) 2 - > K4 ONSO3ONSO3 ONSO3SO3 
    
    */
    public String countOfAtoms(String formula) {
       //Character.getNumericValue(ch)
        if(formula == null || formula.isEmpty()){
            return formula;
        }
        
        formula = flatten(formula);
        
         Map<String, Integer> atomByCount = buildAtomByCount(formula);
        
        Map<String, Integer>  map = Collections.unmodifiableMap(atomByCount);
     
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> entry : atomByCount.entrySet()){
            result.append(entry.getKey());
            if(entry.getValue() > 1){
              result.append(entry.getValue());
            }
        }
        
        return result.toString();
    }
    // K4(ON(SO3)2)2  -> K4 ONSO3ONSO3 ONSO3SO3 
    private String flatten(final String formula){
        Stack<String> contentStack = new Stack<String>();
        StringBuilder content = new StringBuilder();
        int index = 0;
        while(index < formula.length()){
           char ch = formula.charAt(index);
           if(ch == '('){
               contentStack.push(content.toString());
               content = new StringBuilder();
               index++;
           }else if(ch == ')'){
               index++;
               int numCharStartPosition = index;
               while(index < formula.length() && Character.isDigit(formula.charAt(index))){
                   index++;
               }
               System.err.println(numCharStartPosition + ", "+ index );
               int num = Integer.parseInt(formula.substring(numCharStartPosition, index));
               String contentXtimes = buildContentXtimes(content.toString(), num);
               content = new StringBuilder();
               content.append(contentStack.pop())
                      .append(contentXtimes);
           }else{
               content.append(ch);
               index++;
           }
        }
        
        return content.toString();
    }
    
    // K4ONSO3ONSO3ONSO3SO3 -> {'K': 4, 'N': 2, 'O': 14, 'S': 4}
    private Map<String, Integer> buildAtomByCount(final String formula){
         Map<String, Integer> atomByCount = new TreeMap<String, Integer>();
         int index = 0;
         StringBuilder atom = new StringBuilder();
         int num = 1;
         while(index < formula.length()){
             char ch = formula.charAt(index);
             if(Character.isUpperCase(ch)){
                 addToMap(atom.toString(), num, atomByCount);
                 atom = new StringBuilder();
                 num = 1;
                 atom.append(ch);
                 index++;
             }else if(Character.isDigit(ch)){
                 int numStartPosition = index;
                 while(Character.isDigit(formula.charAt(index))){
                     index++;
                 }
                 num = Integer.parseInt(formula.substring(numStartPosition, index));
             }else{
                 atom.append(ch);
                 index++;
             }
         }
        
        addToMap(atom.toString(), num, atomByCount);
        
        return atomByCount;
    }
    
    private void addToMap(String atom, int num, Map<String, Integer> atomByCount){
        if(atom.isEmpty()){
            return;
        }
        
        atomByCount.merge(atom, num, (a, b) -> a + b );
    }
    
    private String buildContentXtimes(final String content, int times){
        StringBuilder result = new StringBuilder();
        while(times > 0){
            result.append(content);
            times--;
        }
        return result.toString();
    }
  public static void main(String[] args) {
    
    NumbersOfAtoms n = new  NumbersOfAtoms();
   // System.err.println("Mg(OH)2".substring(6,7));
    System.err.println(n.countOfAtoms("Mg(OH)2"));

  }

}
