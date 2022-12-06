package com.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment14.domain.User;
import com.assignment14.service.UserService;

@Controller
public class ChannelController {
	
	@Autowired
	UserService userService;
    
    @GetMapping("/channels/{id}")
    public String getChannel (ModelMap model, @PathVariable Long userId) {
    	User user = userService.getUserById(userId);
    	
    	
    	model.put("user", user);
    	return "channel";
    }
    
}
