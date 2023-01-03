package com.bsntech.first.controller;

import com.bsntech.first.domain.drinkwiki.Drinkwiki;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Drinkwiki toEntity() {
        return Drinkwiki.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
