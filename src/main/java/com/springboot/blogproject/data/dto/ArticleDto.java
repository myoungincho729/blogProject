package com.springboot.blogproject.data.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArticleDto {
    private String username;
    private String title;
    private String description;
}
