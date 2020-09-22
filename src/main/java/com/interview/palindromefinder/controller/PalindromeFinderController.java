package com.interview.palindromefinder.controller;

import com.interview.palindromefinder.domain.PalindromeEntity;
import com.interview.palindromefinder.model.PalindromeStoreRepository;
import com.interview.palindromefinder.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "app")
public class PalindromeFinderController {

    @Autowired
    private PalindromeService service;

    @GetMapping("getpalindromes")
    public List<PalindromeEntity> getPalindromeResults(){

        List<PalindromeEntity> palindromeEntities = service.retrieveRecords();
        return palindromeEntities;
    }

    @PostMapping("checkpalindrome")
    public PalindromeEntity findPalindrome(@RequestBody PalindromeEntity entity){
        System.out.println(entity);
        PalindromeEntity palindromeEntity = service.saveRecord(entity);
        return palindromeEntity;
    }

}
