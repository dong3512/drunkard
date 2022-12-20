package com.bsntech.first.domain;

import com.bsntech.first.domain.drinkwiki.DrinkWiki;
import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DrinkWikiRepositoryTest {

    @Autowired
    private DrinkWikiRepository drinkWikiRepository;

    @BeforeEach
    void clean() {
        drinkWikiRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글저장_불러오기")
    public void test1() {
        //given
        drinkWikiRepository.save(DrinkWiki.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build());

        //when
        List<DrinkWiki> drinkWikiList = drinkWikiRepository.findAll();

        // then
        DrinkWiki drinkWiki = drinkWikiList.get(0);
        assertEquals(drinkWiki.getTitle() , "제목");
        assertEquals(drinkWiki.getContent() , "내용");
    }

}
