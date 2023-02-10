package com.springboot.blogproject.service;


import com.springboot.blogproject.data.dto.ArticleDto;
import com.springboot.blogproject.data.dto.ChangeArticleDto;
import com.sun.xml.bind.v2.schemagen.xmlschema.NestedParticle;

public interface BlogService {

    ArticleDto getArticle(Long id);
    ArticleDto saveArticle(ArticleDto articleDto);
    ArticleDto changeArticle(ChangeArticleDto changeArticleDto) throws Exception;
    void deleteArticle(Long id) throws Exception;
}
