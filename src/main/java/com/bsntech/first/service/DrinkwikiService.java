package com.bsntech.first.service;

import com.bsntech.first.domain.drinkwiki.Drinkwiki;
import com.bsntech.first.web.dto.DrinkwikiResponseDto;
import com.bsntech.first.web.dto.DrinkwikiSaveRequestDto;
import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import com.bsntech.first.web.dto.DrinkwikiUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
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

    @Transactional(readOnly = true)
    public DrinkwikiResponseDto findById(Long id) {
        Drinkwiki entity = drinkwikiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new DrinkwikiResponseDto(entity);
    }
}