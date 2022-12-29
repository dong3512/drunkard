package com.bsntech.first.service;

import com.bsntech.first.controller.DrinkwikiSaveRequestDto;
import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Controller
public class DrinkwikiService {
    private DrinkWikiRepository drinkWikiRepository;

    @Transactional
    public Long save(DrinkwikiSaveRequestDto dto) {
        return drinkWikiRepository.save(dto.toEntity()).getId();
    }
}
