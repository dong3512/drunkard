package com.bsntech.first.domain.drinkwiki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface DrinkWikiRepository extends JpaRepository<Drinkwiki, Long> {

    @Query("SELECT d FROM Drinkwiki d ORDER BY d.id DESC")
    Stream<Drinkwiki> findAllDesc();
}
