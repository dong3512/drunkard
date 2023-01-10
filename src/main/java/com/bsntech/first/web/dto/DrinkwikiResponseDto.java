package com.bsntech.first.web.dto;

import com.bsntech.first.domain.drinkwiki.Drinkwiki;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class DrinkwikiResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
//    private String modifiedDate;

    public DrinkwikiResponseDto(Drinkwiki entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
//        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

//    private String toStringDateTime(LocalDateTime localDateTime){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        return Optional.ofNullable(localDateTime)
//                .map(formatter::format)
//                .orElse("");
//
//    }
}
