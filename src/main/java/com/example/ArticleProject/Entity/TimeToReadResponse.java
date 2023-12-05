package com.example.ArticleProject.Entity;

public class TimeToReadResponse {
	private String articleId;
    private TimeToRead timeToRead;
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public TimeToRead getTimeToRead() {
		return timeToRead;
	}
	public void setTimeToRead(TimeToRead timeToRead) {
		this.timeToRead = timeToRead;
	}
	public static class TimeToRead {

		   
	    private int mins;
	    private int seconds;
		public int getMins() {
			return mins;
		}
		public void setMins(int mins) {
			this.mins = mins;
		}
		public int getSeconds() {
			return seconds;
		}
		public void setSeconds(int seconds) {
			this.seconds = seconds;
		}
	    
	}
}
