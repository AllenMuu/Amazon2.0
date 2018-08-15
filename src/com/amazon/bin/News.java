package com.amazon.bin;

public class News {
	private int newsId;
	private String newsTitle;
	private String newsContent;
	private String newsCreateTime;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsCreateTime() {
		return newsCreateTime;
	}
	public void setNewsCreateTime(String newsCreateTime) {
		this.newsCreateTime = newsCreateTime;
	}
	public News() {
		super();
	}
	
}
