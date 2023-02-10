package com.springboot.blogproject.data.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangeArticleDto {
    private Long id;
    private String title;
    private String description;
}
