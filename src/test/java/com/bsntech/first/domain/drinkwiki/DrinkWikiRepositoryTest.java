package com.bsntech.first.domain.drinkwiki;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrinkWikiRepositoryTest {

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
        drinkWikiRepository.save(DrinkWiki.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build());

        //when
        List<DrinkWiki> drinkWikiList = drinkWikiRepository.findAll();

        // then
        DrinkWiki drinkWiki = drinkWikiList.get(0);
        assertThat(drinkWiki.getTitle() , is("제목"));
        assertThat(drinkWiki.getContent() ,is ("내용"));
    }

}
