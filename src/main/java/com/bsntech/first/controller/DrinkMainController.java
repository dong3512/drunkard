package com.bsntech.first.controller;

import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DrinkMainController {

    private DrinkWikiRepository drinkWikiRepository;

    @GetMapping("/main")
    public String get() {
        return "MAIN";
    }

    @PostMapping("/drinkwikis")
    public void saveDrinkwiki(@RequestBody DrinkwikiSaveRequestDto dto) {
        drinkWikiRepository.save(dto.toEntity());
    }
}
