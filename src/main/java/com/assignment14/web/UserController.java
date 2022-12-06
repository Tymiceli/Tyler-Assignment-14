package com.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignment14.domain.Channel;
import com.assignment14.domain.User;
import com.assignment14.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/welcome")
    public String getWelcomePage(ModelMap model) {
//        Channel channel = new Channel();
        User user = new User();
        Channel channel = new Channel();
        
        channel.setName("General");
        
        user.getChannels().add(channel);
        
        userService.save(user);
        
        model.put("user", user);
        return "welcome";
    }
}
