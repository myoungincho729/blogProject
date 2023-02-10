package com.springboot.blogproject.controller;

import com.springboot.blogproject.data.dto.ArticleDto;
import com.springboot.blogproject.data.dto.ChangeArticleDto;
import com.springboot.blogproject.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class Controller {

    private final BlogService blogService;

    Controller(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping
    public String home(){
        return "hi myoungin";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id){
        ArticleDto articleDto = blogService.getArticle(id);

        return ResponseEntity.status(HttpStatus.OK).body(articleDto);
    }

    @PostMapping
    public ResponseEntity<ArticleDto> saveArticle(@RequestBody ArticleDto articleDto){
        System.out.println("post");
        ArticleDto savedArticleDto = blogService.saveArticle(articleDto);

        return ResponseEntity.status(HttpStatus.OK).body(savedArticleDto);
    }

    @PutMapping
    public ResponseEntity<ArticleDto> changeArticle(
            @RequestBody ChangeArticleDto changeArticleDto) throws Exception {

        ArticleDto changedArticleDto = blogService.changeArticle(changeArticleDto);

        return ResponseEntity.status(HttpStatus.OK).body(changedArticleDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteArticle(Long id) throws Exception {
        blogService.deleteArticle(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
