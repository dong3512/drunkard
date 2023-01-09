package com.bsntech.first.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DrinkwikiUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public DrinkwikiUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
