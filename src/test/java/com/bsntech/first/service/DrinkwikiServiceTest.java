package com.bsntech.first.service;

import com.bsntech.first.controller.DrinkwikiSaveRequestDto;
import com.bsntech.first.domain.drinkwiki.DrinkWiki;
import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrinkwikiServiceTest {

    @Autowired
    private DrinkwikiService drinkwikiService;

    @Autowired
    private DrinkWikiRepository drinkWikiRepository;

    @After
    public void cleanup() {
        drinkWikiRepository.deleteAll();
    }

    @Test
    @DisplayName("Dto데이터가 drinkwiki테이블에 저장된다")
    public void test1() {
        //given
        DrinkwikiSaveRequestDto dto = DrinkwikiSaveRequestDto.builder()
                .author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        drinkwikiService.save(dto);

        //then
        DrinkWiki drinkwiki = drinkWikiRepository.findAll().get(0);
        assertThat(drinkwiki.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(drinkwiki.getContent()).isEqualTo(dto.getContent());
        assertThat(drinkwiki.getTitle()).isEqualTo(dto.getTitle());
    }
}