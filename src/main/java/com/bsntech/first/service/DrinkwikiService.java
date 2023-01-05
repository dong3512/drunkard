package com.bsntech.first.service;

import com.bsntech.first.controller.DrinkwikiMainResponseDto;
import com.bsntech.first.controller.DrinkwikiSaveRequestDto;
import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import com.bsntech.first.domain.drinkwiki.Drinkwiki;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
public class DrinkwikiService {

    private DrinkWikiRepository drinkWikiRepository;

    @Transactional
    public Long save(DrinkwikiSaveRequestDto dto) {
        return drinkWikiRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<DrinkwikiMainResponseDto> findAllDesc() {
        return drinkWikiRepository.findAllDesc()
                .map(DrinkwikiMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
