package com.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment14.domain.Channel;
import com.assignment14.domain.Message;
import com.assignment14.service.ChannelService;
import com.assignment14.service.MessageService;

@Controller
public class ChannelController {
	
	@Autowired
	ChannelService channelService;
	@Autowired
	MessageService messageService;
	
	@GetMapping("/")
	public String redirectToWelcome() {
		return "redirect:/welcome";
	}
    
    @GetMapping("/channels/{channelId}")
    public String getChannel (ModelMap model, @PathVariable Long channelId) {
    	Channel channel = channelService.findById(channelId);
    	List<Message> messages = messageService.getMessagesFromChannel(channelId);
    	
    	model.put("messages", messages);
    	model.put("channel", channel);
    	return "channel";
    }
    
    @GetMapping("/welcome")
    public String getWelcomePage (ModelMap model) {
    	List<Channel> channels = channelService.findAll();
    	model.put("channels", channels);
    	return "welcome";
    }
    
    @PostMapping ("/create-channel")
    public String createChannel (@RequestParam String channelName) {
    	channelService.save(channelName);
    	
    	return "redirect:/";
    }
}
