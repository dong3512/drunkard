package com.bsntech.first.domain.drinkwiki;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrinkwikiRepositoryTest {

    @Autowired
    private DrinkWikiRepository drinkWikiRepository;

    @After
    public void cleanup() {
        drinkWikiRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글저장_불러오기")
    public void test1() {
        //given
        drinkWikiRepository.save(Drinkwiki.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build());

        //when
        List<Drinkwiki> drinkwikiList = drinkWikiRepository.findAll();

        // then
        Drinkwiki drinkWiki = drinkwikiList.get(0);
        assertThat(drinkWiki.getTitle() , is("제목"));
        assertThat(drinkWiki.getContent() ,is ("내용"));
    }

    @Test
    @DisplayName("BaseTimeEntity_등록")
    public void test2() {
        // given
        LocalDateTime now = LocalDateTime.now();

        drinkWikiRepository.save(Drinkwiki.builder()
                .title("테스트 게시글")
                .content("테스트 내용")
                .author("동인리")
                .build());

        // when
        List<Drinkwiki> drinkwikiList = drinkWikiRepository.findAll();

        // then
        Drinkwiki drinkWiki = drinkwikiList.get(0);
        assertTrue(drinkWiki.getCreatedDate().isAfter(now));
        assertTrue(drinkWiki.getModifiedDate().isAfter(now));
    }

}
