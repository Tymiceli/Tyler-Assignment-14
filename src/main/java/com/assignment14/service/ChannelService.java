package com.assignment14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment14.domain.Channel;
import com.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository channelRepo;

	public List<Channel> findAll() {
		List<Channel> allChannels = channelRepo.findAll(); 
		return allChannels;
	}

	public Channel findById(Long channelId) {
		Channel channel = channelRepo.findById(channelId);
		return channel;
	}
}
