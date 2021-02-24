package com.self.gs.iterators.channel.filter;

public class TVStation {
	private String name;
	private ChannelLanguage channelLanguage;

	public TVStation(String name, ChannelLanguage channelLanguage) {
		super();
		this.name = name;
		this.channelLanguage = channelLanguage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChannelLanguage getChannelLanguage() {
		return channelLanguage;
	}

	public void setChannelLanguage(ChannelLanguage channelLanguage) {
		this.channelLanguage = channelLanguage;
	}

	@Override
	public String toString() {
		return "TVStation [name=" + name + ", channelLanguage=" + channelLanguage + "]";
	}

}
