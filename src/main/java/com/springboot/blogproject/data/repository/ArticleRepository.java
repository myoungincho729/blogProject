package com.springboot.blogproject.data.repository;

import com.springboot.blogproject.data.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByUsername(String username);
}
