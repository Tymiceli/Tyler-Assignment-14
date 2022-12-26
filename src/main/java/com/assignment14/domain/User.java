package com.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private Long id;
    private String name;
    private List<Message> messages = new ArrayList<>();
    private List<Channel> channels = new ArrayList<>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", messages=" + messages + ", channels=" + channels + "]";
	}
    
    
    
}
