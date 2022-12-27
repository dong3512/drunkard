package com.bsntech.first.domain.drinkwiki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface DrinkWikiRepository extends JpaRepository<DrinkWiki, Long> {
}
