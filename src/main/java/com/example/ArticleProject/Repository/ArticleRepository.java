package com.example.ArticleProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ArticleProject.Entity.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
	Article findBySlug(String slug);

}
