package com.self.gs.iterators.channel.filter;

public class Main{

	 public static void main(String[] args) {
		 TVStationCollection tvStationCollection = new TVStationCollectionImpl();
		 tvStationCollection.addChannel(new TVStation("NBC", ChannelLanguage.ENGLISH));
		 tvStationCollection.addChannel(new TVStation("ENBC", ChannelLanguage.SPANISH));
		 tvStationCollection.addChannel(new TVStation("VIJAY", ChannelLanguage.TAMIL));
		 tvStationCollection.addChannel(new TVStation("BBC", ChannelLanguage.ENGLISH));

		 System.out.println("******ALL *****");
		 
		 TVStationIterator tvStationIterator = tvStationCollection.iterator(ChannelLanguage.ALL);
		 tvStationCollection.addChannel(new TVStation("NEW", ChannelLanguage.ENGLISH));
		 while(tvStationIterator.hasNext()) {
			 System.out.println(tvStationIterator.next());
		 }
		 
		 System.out.println("****** English *****");
		 tvStationIterator = tvStationCollection.iterator(ChannelLanguage.ENGLISH);
		 while(tvStationIterator.hasNext()) {
			 System.out.println(tvStationIterator.next());
		 }
		 
		 
	}

}
