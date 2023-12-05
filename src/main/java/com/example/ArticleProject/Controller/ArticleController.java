package com.example.ArticleProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ArticleProject.Entity.Article;
import com.example.ArticleProject.Entity.ArticleRequest;
import com.example.ArticleProject.Entity.TimeToReadResponse;
import com.example.ArticleProject.Service.ArticleService;

@RestController
@RequestMapping("/article")

@CrossOrigin(origins="http://localhost:4200")
public class ArticleController {
	
	@Autowired
	public ArticleService articleService;
	 @PostMapping("/create-article")
	    public Article createArticle(@RequestBody ArticleRequest articleRequest) {
	        return articleService.createArticle(articleRequest);
	    }
	 
	 @PutMapping("/update-article/{id}")
	    public Article updateArticle(@PathVariable Long id, @RequestBody ArticleRequest articleRequest) {
	        return articleService.updateArticle(id, articleRequest);
	    }
	 
	 @GetMapping("/get-article/{id}")
	    public Article getArticleById(@PathVariable Long id) {
	        return articleService.getArticleById(id);
	    }
	 @DeleteMapping("/delete-article/{id}")
	    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
	        articleService.deleteArticleById(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	 @GetMapping("/getAllArticleDetails")
		public ResponseEntity<List<Article>> getAllBusDetails(){
			List<Article> list = articleService.getAllArticleDetails();
			return ResponseEntity.ok().body(list);
		}
	 @GetMapping("/time-to-read-article/{id}")
	    public TimeToReadResponse getTimeToRead(@PathVariable long id) {
	        return articleService.calculateTimeToReadById(id);
	    }

}
