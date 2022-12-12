package com.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.assignment14.domain.Channel;

@Component
public class ChannelRepository {
	
	private List<Channel> channels = new ArrayList<>();
	
	public ChannelRepository () {
		Channel general = new Channel();
		general.setChannelId(1L);
		general.setName("General");
		
		channels.add(general);
	}

	public Channel findById(Long channelId) {
		Optional<Channel> channelFoundById = 
				channels.stream()
						.filter(channel -> channel.getChannelId().equals(channelId))
						.findAny();
		return channelFoundById.orElse(new Channel());
	}
	
	public List<Channel> findAll() {
		return channels;
	}
}
