package com.self.gs.iterators.channel.filter;

public interface TVStationCollection {
	public void addChannel(TVStation tvStation);
	public void removeChannel(TVStation tvStation);
	public TVStationIterator iterator(ChannelLanguage channelLanguage);
}
