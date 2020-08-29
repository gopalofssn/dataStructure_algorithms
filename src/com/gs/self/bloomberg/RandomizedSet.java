package com.gs.self.bloomberg;

import java.util.*;

public class RandomizedSet {

  private Map<Integer, Integer> valueAndLocationMap;
  private List<Integer> locationList;
  private Random random;
  
  /** Initialize your data structure here. */
  public RandomizedSet() {
      valueAndLocationMap = new HashMap<Integer, Integer>();
      locationList = new ArrayList<Integer>();
      random = new Random();
  }
  
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
      if(valueAndLocationMap.containsKey(val)){
          return false;
      }
      int loc = locationList.size();
      valueAndLocationMap.put(val, loc);
      locationList.add(val);
      return true;
  }
  
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
      if(!valueAndLocationMap.containsKey(val)){
          return false;
      }
      
      
      if(valueAndLocationMap.size() == 1) {
        valueAndLocationMap.clear();
        locationList.clear();
        return true;
      }
      
      int loc = valueAndLocationMap.get(val);
      valueAndLocationMap.remove(val);
      int listLastLoc = locationList.size() - 1;
      int listLastVal = locationList.get(listLastLoc);
      valueAndLocationMap.put(listLastVal, loc);
      swapElementInlocationList(loc, listLastLoc);
      locationList.remove(listLastLoc);
      
      System.err.println(valueAndLocationMap);
      return true;
      
  }
  
  private void swapElementInlocationList(int loc1, int loc2){
      int tmp1 = locationList.get(loc1);
      int tmp2 = locationList.get(loc2);
      locationList.set(loc1, tmp2);
       locationList.set(loc2, tmp1);
  }
  /** Get a random element from the set. */
  public int getRandom() {
      int i = random.nextInt(locationList.size());
      return locationList.get(i);
  }
  public static void main(String}] args) {
    RandomizedSet set = new RandomizedSet();
    System.err.println(set.remove(0));
    System.err.println(set.remove(0));
    System.err.println(set.insert(0));
    
    System.err.println(set.getRandom());
    System.err.println(set.remove(0));
    System.err.println(set.insert(0));
    
  }

}
