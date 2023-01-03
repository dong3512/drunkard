package com.bsntech.first.controller;

import com.bsntech.first.domain.drinkwiki.Drinkwiki;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DrinkwikiMainResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public DrinkwikiMainResponseDto(Drinkwiki entity){
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");

    }
}
