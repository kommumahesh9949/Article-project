package com.example.ArticleProject.Entity;

public class ArticleRequest {

    private String title;
    private String description;
    private String body;
    
	public ArticleRequest(String title, String description, String body) {
		super();
		this.title = title;
		this.description = description;
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

   
}
