package com.assignment14.repository;

import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.assignment14.domain.Message;

@Component
public class MessageRepository {

	public Map<Long, List<Message>> messages = new HashMap<>();
	
	public Optional<List<Message>> getMessagesFromChannel(Long channelId) {
		List<Message> messagesInChannel = messages.get(channelId);
		
		return Optional.ofNullable(messagesInChannel);
	}
	
//	public void saveMessagesInChannel(Long channelId, List<Message> messagesInChannel) {
	public void saveMessagesInChannel(Long channelId, List<Message> messagesInChannel) {
		messages.put(channelId, messagesInChannel);
	}

}
