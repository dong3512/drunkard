package com.bsntech.first.controller;

import com.bsntech.first.domain.drinkwiki.DrinkWiki;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class DrinkwikiSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public DrinkwikiSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public DrinkWiki toEntity() {
        return DrinkWiki.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
