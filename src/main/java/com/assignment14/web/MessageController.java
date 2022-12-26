package com.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment14.domain.Message;
import com.assignment14.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messages/{channelId}")
	public List<Message> getMessagesByChannelId (@PathVariable Long channelId) {
		List<Message> channelMessages = messageService.getMessagesFromChannel(channelId);
//		System.out.println(channelMessages.size());
		return channelMessages;
	}
	
	@PostMapping("/messages") 
	public Message postMessagesToUserId (@RequestBody Message message) {
		messageService.saveMessageToChannel(message);
		System.out.println(message);
		return message;
	}
}
