package com.springboot.blogproject.repository;

import com.springboot.blogproject.data.entity.Article;
import com.springboot.blogproject.data.repository.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void basicCrudTest(){

        Article article = Article.builder()
                .username("myoungin")
                .id(1L)
                .title("code")
                .description("leaning spring boot")
                .build();

        Article savedArticle = articleRepository.save(article);

        Assertions.assertThat(article.getDescription())
                .isEqualTo(savedArticle.getDescription());
        Assertions.assertThat(article.getUsername())
                .isEqualTo(savedArticle.getUsername());
        Assertions.assertThat(article.getId())
                .isEqualTo(savedArticle.getId());
        Assertions.assertThat(article.getTitle())
                .isEqualTo(savedArticle.getTitle());

        Article foundArticle = articleRepository.findById(article.getId()).get();
        Article foundUsernameArticle = articleRepository.findByUsername(article.getUsername());

        Assertions.assertThat(article.getDescription())
                .isEqualTo(foundArticle.getDescription());
        Assertions.assertThat(article.getUsername())
                .isEqualTo(foundUsernameArticle.getUsername());
        Assertions.assertThat(article.getId())
                .isEqualTo(foundArticle.getId());
        Assertions.assertThat(article.getTitle())
                .isEqualTo(foundArticle.getTitle());

        Assertions.assertThat(foundArticle.getDescription())
                .isEqualTo(foundUsernameArticle.getDescription());
        Assertions.assertThat(foundArticle.getUsername())
                .isEqualTo(foundUsernameArticle.getUsername());
        Assertions.assertThat(foundArticle.getId())
                .isEqualTo(foundUsernameArticle.getId());
        Assertions.assertThat(foundArticle.getTitle())
                .isEqualTo(foundUsernameArticle.getTitle());
    }
}
