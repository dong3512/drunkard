package com.bsntech.first.service;

import com.bsntech.first.domain.drinkwiki.Drinkwiki;
import com.bsntech.first.web.dto.DrinkwikiResponseDto;
import com.bsntech.first.web.dto.DrinkwikiSaveRequestDto;
import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import com.bsntech.first.web.dto.DrinkwikiUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
public class DrinkwikiService {

    private DrinkWikiRepository drinkwikiRepository;

    @Transactional
    public Long save(DrinkwikiSaveRequestDto requestDto) {
        return drinkwikiRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, DrinkwikiUpdateRequestDto requestDto) {
        Drinkwiki drinkwiki = drinkwikiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        drinkwiki.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public DrinkwikiResponseDto findById(Long id) {
        Drinkwiki entity = drinkwikiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new DrinkwikiResponseDto(entity);
    }
}
