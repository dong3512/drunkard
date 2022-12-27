package com.bsntech.first.controller;

import com.bsntech.first.domain.drinkwiki.DrinkWiki;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

public class DrinkwikiSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public DrinkWiki toEntity() {
        return DrinkWiki.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
