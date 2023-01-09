package com.bsntech.first.web;

import com.bsntech.first.web.dto.DrinkwikiResponseDto;
import com.bsntech.first.web.dto.DrinkwikiSaveRequestDto;
import com.bsntech.first.service.DrinkwikiService;
import com.bsntech.first.web.dto.DrinkwikiUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DrinkwikiApiController {

    private final DrinkwikiService drinkwikiService;

    @PostMapping("api/v1/drinkwiki")
    public Long save(@RequestBody DrinkwikiSaveRequestDto requestDto){
        return drinkwikiService.save(requestDto);
    }

    @PutMapping("/api/v1/drinkwiki/{id}")
    public Long update(@PathVariable Long id, @RequestBody DrinkwikiUpdateRequestDto requestDto){
        return drinkwikiService.update(id, requestDto);
    }

    @GetMapping("/api/v1/drinkwiki/{id}")
    public DrinkwikiResponseDto findById(@PathVariable Long id){
        return drinkwikiService.findById(id);
    }
}
