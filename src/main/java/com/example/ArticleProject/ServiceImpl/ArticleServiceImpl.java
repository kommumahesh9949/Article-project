package com.example.ArticleProject.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ArticleProject.Entity.Article;
import com.example.ArticleProject.Entity.ArticleRequest;
import com.example.ArticleProject.Entity.TimeToReadResponse;
import com.example.ArticleProject.Repository.ArticleRepository;
import com.example.ArticleProject.Service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	public ArticleRepository articleRepository;


	public Article createArticle(ArticleRequest articleRequest) {
		String slug = generateSlug(articleRequest.getTitle());
		LocalDateTime now = LocalDateTime.now();

		Article article = new Article();
		article.setSlug(slug);
		article.setTitle(articleRequest.getTitle());
		article.setDescription(articleRequest.getDescription());
		article.setBody(articleRequest.getBody());
		article.setCreatedAt(now);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		article.setUpdatedAt(now);

		return articleRepository.save(article);
	}

	private String generateSlug(String title) {
		return title.toLowerCase().replaceAll("[^a-z0-9\\s-]", "").replaceAll("\\s+", "-");
	}

	public Article updateArticle(Long id, ArticleRequest articleRequest) {
		Article existingArticle = articleRepository.findById(id).orElse(null);

		if (existingArticle != null) {
			// Update fields if present in the request
			if (articleRequest.getTitle() != null) {
				existingArticle.setTitle(articleRequest.getTitle());
			}

			if (articleRequest.getDescription() != null) {
				existingArticle.setDescription(articleRequest.getDescription());
			}

			if (articleRequest.getBody() != null) {
				existingArticle.setBody(articleRequest.getBody());
			}

			// Update the slug
			existingArticle.setSlug(generateSlug(existingArticle.getTitle()));

			// Update the updatedAt timestamp
			existingArticle.setUpdatedAt(LocalDateTime.now());

			return articleRepository.save(existingArticle);
		}

		// Handle case when article with the given ID is not found
		return null;
	}
	//logic for getbyid
	public Article getArticleById(Long id) {
		return articleRepository.findById(id).orElse(null);
	}
	public List<Article> getAllArticleDetails() {
		return articleRepository.findAll();
	}
	//delete article by id
	public void deleteArticleById(Long id) {
		articleRepository.deleteById(id);
	}

	public TimeToReadResponse calculateTimeToReadById(Long id) {
		Article article = articleRepository.findById(id).orElse(null);

		if (article != null) {
			int words = countWords(article.getBody());
			int averageSpeed=200;
			int totalTime = calculateTimeToRead(words, averageSpeed);
			int minutes = totalTime / 60;
			int seconds = totalTime % 60;

			TimeToReadResponse timeToReadResponse = new TimeToReadResponse();
			timeToReadResponse.setArticleId(article.getSlug());

			TimeToReadResponse.TimeToRead timeToRead = new TimeToReadResponse.TimeToRead();
			timeToRead.setMins(minutes);
			timeToRead.setSeconds(seconds);

			timeToReadResponse.setTimeToRead(timeToRead);

			return timeToReadResponse;
		}

		return null;  // Handle case when article with the given ID is not found
	}
	private int countWords(String text) {
		// Remove non-alphanumeric characters and split the text into words based on spaces
		String[] words = text.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

		// Count the number of words
		return words.length;
	}
	private int calculateTimeToRead(int words, int speed) {
		return (int) Math.ceil((double) words / speed);
	}
}


