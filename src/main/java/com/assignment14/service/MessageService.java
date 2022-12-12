package com.assignment14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment14.domain.Channel;
import com.assignment14.domain.Message;
import com.assignment14.repository.ChannelRepository;
import com.assignment14.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	ChannelRepository channelRepo;
	@Autowired
	MessageRepository messageRepo;

	public List<Message> getMessagesFromChannel(Long channelId) {
		return messageRepo.getMessagesFromChannel(channelId).orElse(new ArrayList<>());
		
	}
	
	public void saveMessageToChannel(Message message) {
		Long channelId = message.getChannelId();
		Optional<Channel> channelOpt = Optional.ofNullable(channelRepo.findById(channelId));
		if (channelOpt.isPresent()) {
			List<Message> messagesInChannel = getMessagesFromChannel(channelId);
			messagesInChannel.add(message);
			messageRepo.saveMessagesInChannel(channelId, messagesInChannel);
		}
	}
}
