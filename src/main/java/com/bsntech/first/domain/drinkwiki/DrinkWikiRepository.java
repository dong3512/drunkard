package com.bsntech.first.domain.drinkwiki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

public interface DrinkWikiRepository extends JpaRepository<DrinkWiki, Long> {

    @Query("SELECT p" +
            "FROM DRINK_WIKI" +
            "ORDER BY p.id DESC")
    Stream<DrinkWiki> findAllDesc();
}
