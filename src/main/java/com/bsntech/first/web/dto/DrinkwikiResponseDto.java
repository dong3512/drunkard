package com.bsntech.first.web.dto;

import com.bsntech.first.domain.drinkwiki.Drinkwiki;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DrinkwikiResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

    public DrinkwikiResponseDto(Drinkwiki entity){
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
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
