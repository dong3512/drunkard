package com.bsntech.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkMainController {

    @GetMapping("/main")
    public String get() {
        return "MAIN";
    }
}
