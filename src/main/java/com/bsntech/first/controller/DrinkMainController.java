package com.bsntech.first.controller;

import com.bsntech.first.domain.drinkwiki.DrinkWikiRepository;
import com.bsntech.first.service.DrinkwikiService;
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

    private DrinkwikiService drinkwikiService;

    @GetMapping("/main")
    public String get() {
        return "MAIN";
    }

    @PostMapping("/drinkwikis")
    public Long saveDrinkwiki(@RequestBody DrinkwikiSaveRequestDto dto) {
        return drinkwikiService.save(dto);
    }
}
