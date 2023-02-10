package com.springboot.blogproject.service.impl;

import com.springboot.blogproject.data.dto.ArticleDto;
import com.springboot.blogproject.data.dto.ChangeArticleDto;
import com.springboot.blogproject.data.entity.Article;
import com.springboot.blogproject.data.repository.ArticleRepository;
import com.springboot.blogproject.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    ArticleRepository articleRepository;

    public BlogServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto getArticle(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        Article article = optionalArticle.get();

        ArticleDto articleDto = new ArticleDto();
        articleDto.setUsername(article.getUsername());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());
        return articleDto;
    }

    @Override
    public ArticleDto saveArticle(ArticleDto articleDto) {
        Article article = new Article();
        article.setUsername(articleDto.getUsername());
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());

        Article savedArticle = articleRepository.save(article);

        ArticleDto saveArticleDto = new ArticleDto();
        saveArticleDto.setUsername(savedArticle.getUsername());
        savedArticle.setTitle(savedArticle.getTitle());
        savedArticle.setDescription(savedArticle.getDescription());

        return saveArticleDto;
    }

    @Override
    public ArticleDto changeArticle(ChangeArticleDto changeArticleDto) throws Exception{
        Article foundArticle = articleRepository.findById(changeArticleDto.getId()).get();

        foundArticle.setTitle(changeArticleDto.getTitle());
        foundArticle.setDescription(changeArticleDto.getDescription());

        Article changedArticle = articleRepository.save(foundArticle);

        ArticleDto changedArticleDto = new ArticleDto();
        changedArticleDto.setUsername(changedArticle.getUsername());
        changedArticleDto.setTitle(changedArticle.getTitle());
        changedArticleDto.setDescription(changedArticle.getDescription());
        return changedArticleDto;
    }

    @Override
    public void deleteArticle(Long id) throws Exception{
        articleRepository.deleteById(id);
    }
}
