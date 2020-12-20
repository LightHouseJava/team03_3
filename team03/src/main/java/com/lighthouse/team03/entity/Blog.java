package com.lighthouse.team03.entity;

public class Blog {
	private String username;
	private String title;
	private String subtitle;
	private String body;
	private byte[] image;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "Blog [username=" + username + ", title=" + title + ", subtitle=" + subtitle + ",body=" + body + ",image=" + image + "]";
	}
}
