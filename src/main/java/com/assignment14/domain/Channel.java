package com.assignment14.domain;

public class Channel {

	private Long channelId;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long id) {
		this.channelId = id;
	}
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", name=" + name + "]";
	}
}
