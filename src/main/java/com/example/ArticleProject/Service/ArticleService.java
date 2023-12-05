package com.example.ArticleProject.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ArticleProject.Entity.Article;
import com.example.ArticleProject.Entity.ArticleRequest;
import com.example.ArticleProject.Entity.TimeToReadResponse;
import com.example.ArticleProject.Repository.ArticleRepository;


public interface ArticleService {
	public Article createArticle(ArticleRequest articleRequest);
	public Article updateArticle(Long id, ArticleRequest articleRequest);
	public Article getArticleById(Long id) ;
	public List<Article> getAllArticleDetails();
	public void deleteArticleById(Long id);
	public TimeToReadResponse calculateTimeToReadById(Long id);


}