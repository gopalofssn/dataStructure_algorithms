package com.gs.self.cache;

import java.util.*;

public class  Twitter {

  Map<Integer, LinkedList<Integer>> userIdAndTweet;
  Map<Integer, Set<Integer>> followeeeIdAndFollowerIdsMap;
  
  /** Initialize your data structure here. */
  public Twitter() {
      userIdAndTweet = new LinkedHashMap<Integer, LinkedList<Integer>>();
      followeeeIdAndFollowerIdsMap = new HashMap<Integer, Set<Integer>>();
  }
  
  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
      
      followeeeIdAndFollowerIdsMap.computeIfAbsent(userId, K -> new HashSet<Integer>(Arrays.asList(userId)));
      Set<Integer> followerList = followeeeIdAndFollowerIdsMap.get(userId);
      
      for(Integer follower : followerList){
          userIdAndTweet.computeIfAbsent(follower, K -> new LinkedList<Integer>());
          LinkedList<Integer> userTweetList = userIdAndTweet.get(follower);
          userTweetList.addFirst(tweetId);
          while(userTweetList.size() > 10){
              userTweetList.removeLast();
          }
          
      }
     
      //System.err.println("followeeeIdAndFollowerIdsMap" + followeeeIdAndFollowerIdsMap);
      //System.err.println("userIdAndTweet" + userIdAndTweet);
  }
  
  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
      
      return userIdAndTweet.get(userId);
  }
  
  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
      
     followeeeIdAndFollowerIdsMap.computeIfAbsent(followeeId, K -> new HashSet<Integer>(Arrays.asList(followeeId)));
     followeeeIdAndFollowerIdsMap.get(followeeId).add(followerId);

  }
  
  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
      if(followerId == followeeId){
          return;
      }
      Set<Integer> followerList = followeeeIdAndFollowerIdsMap.get(followeeId);
      
      if(followerList != null && followerList.contains(followerId)){
          followerList.remove(followerId);
      }
  }


  public static void main(String[] args) {
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 101);
    twitter.postTweet(1, 102);
    twitter.follow(2, 1);
    //twitter.getNewsFeed(2);
    twitter.postTweet(1, 103);
    
    twitter.unfollow(1, 2);
    twitter.postTweet(1, 104);
    
    
   System.err.println( twitter.getNewsFeed(2));

  }

}
