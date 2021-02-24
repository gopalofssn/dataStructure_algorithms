package com.self.gs.iterators.channel.filter;

import java.util.*;

public class TVStationCollectionImpl implements TVStationCollection {

	private List<TVStation> tvStationList = new ArrayList<TVStation>();

	@Override
	public void addChannel(TVStation tvStation) {
		tvStationList.add(tvStation);
	}

	@Override
	public void removeChannel(TVStation tvStation) {
		tvStationList.remove(tvStation);
	}

	@Override
	public TVStationIterator iterator(ChannelLanguage channelLanguage) {
		return new TVStationIteratorImpl(channelLanguage, tvStationList);
	}

	private class TVStationIteratorImpl implements TVStationIterator {

		private ChannelLanguage channelLanguage;
		private List<TVStation> tvStationList;
		private int position;

		public TVStationIteratorImpl(ChannelLanguage channelLanguage, List<TVStation> tvStationList) {
			this.channelLanguage = channelLanguage;
			this.tvStationList = tvStationList;
			movePositionToSpecificLanguageChannel();
		}

		private void movePositionToSpecificLanguageChannel() {
			if (channelLanguage.equals(ChannelLanguage.ALL)) {
				return;
			}
			while (position < tvStationList.size()) {
				TVStation tvStation = tvStationList.get(position);
				if (tvStation.getChannelLanguage().equals(channelLanguage)) {
					return;
				}
				position++;
			}
		}

		@Override
		public boolean hasNext() {
			movePositionToSpecificLanguageChannel();
			if (position >= tvStationList.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public TVStation next() {
			TVStation tvStation = tvStationList.get(position);
			position++;
			return tvStation;
		}

	}

}
