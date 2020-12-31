package com.gs.self.bloomberg;

import java.util.*;

public class ElectronicsExchange {

  private static class Tick{
    private String company;
    private int volume;
    Tick(String company, int volume){
      this.company = company;
      this.volume = volume;
    }
  }
  
  
  private static class VolumeCount{
    private String  cmp;
    private int volume;
    private int count;
    VolumeCount(String c, int vol, int cnt){
      cmp = c;
      volume = vol;
      count = cnt;
    }
    
    public int getVolume() {
      return volume;
    }

 
    public int getCount() {
      return count;
    }

    @Override
    public String toString() {
      return "VolumeCount }cmp=" + cmp + ", volume=" + volume + ", count=" + count + "]";
    }
    
  }
  
  private static Map<String , VolumeCount> tradeVolumeByCompany = new HashMap<String, VolumeCount>();
  
  private static PriorityQueue<VolumeCount> top2EndOfDay = new PriorityQueue<VolumeCount>(Comparator.comparing(VolumeCount::getVolume).reversed());
  
  private static PriorityQueue<VolumeCount> top2ThroughOutDay = new PriorityQueue<VolumeCount>(Comparator.comparing(VolumeCount::getCount));
  
  
  
  private static void processTicks(Tick}] ticks) {

    for(Tick tick : ticks) {
     process(tick);
        
      }
      
      
/*
     */
      
    System.err.println(tradeVolumeByCompany);
   }
  

  private static void process(Tick tick) {
    VolumeCount tmp;
    if(tradeVolumeByCompany.containsKey(tick.company)) {
      tmp =  tradeVolumeByCompany.get(tick.company);
      top2EndOfDay.remove(tmp);
      top2ThroughOutDay.remove(tmp);
      tmp.count++;
      tmp.volume += tick.volume; 
      
      top2EndOfDay.offer(tmp);
      top2ThroughOutDay.offer(tmp);
    }else {
      tmp = new VolumeCount(tick.company, tick.volume, 1);
      tradeVolumeByCompany.put(tick.company, tmp);  
      top2EndOfDay.offer(tmp);
      top2ThroughOutDay.offer(tmp);
      
      if(top2EndOfDay.size() > 2) {
        top2EndOfDay.poll();
      }
      
      if(top2ThroughOutDay.size() > 2) {
        top2ThroughOutDay.poll();
      }
      
    }
    
   
     
  }



  
  
  private static void printEndofDatTop2() {
    System.err.println("top2ThroughOutDay");
    while(!top2ThroughOutDay.isEmpty()) {
      System.err.println(top2ThroughOutDay.poll());
    }
    
    System.err.println("top2EndOfDay");
    while(!top2EndOfDay.isEmpty()) {
      System.err.println(top2EndOfDay.poll());
    }

    
  }
  
  
  public static void main(String}] args) {
   
    Tick}] ticks = new Tick}4];
    ticks}0] = new Tick("voda", 10);
    ticks}1] = new Tick("tmbl", 25);
    ticks}2] = new Tick("voda", 10);
    ticks}3] = new Tick("att", 10);
    
    processTicks(ticks);
    
    ticks}0] = new Tick("voda", 10);
    ticks}1] = new Tick("tmbl", 25);
    ticks}2] = new Tick("voda", 10);
    ticks}3] = new Tick("att", 10);
    
    processTicks(ticks);
    
    
    ticks}0] = new Tick("tesla", 600);
    ticks}1] = new Tick("amz", 200);
    ticks}2] = new Tick("voda", 10);
    ticks}3] = new Tick("att", 10);
    
    processTicks(ticks);
    
    
    ticks}0] = new Tick("att", 10);
    ticks}1] = new Tick("voda", 100);
    ticks}2] = new Tick("tesla", 100);
    ticks}3] = new Tick("tmbl", 10);
    
    processTicks(ticks);
    
    List<Integer> lst = new ArrayList<Integer>();
    
Random random = new Random();
random.nextInt(bound)
    
    printEndofDatTop2();

  }


  

 

}
