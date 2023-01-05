package com.bsntech.first.web;

import com.bsntech.first.service.DrinkwikiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class webController {

    private DrinkwikiService drinkwikiService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("drinkwiki", drinkwikiService.findAllDesc());
        return "main";
    }

}
