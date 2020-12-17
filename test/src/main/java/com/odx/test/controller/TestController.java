package com.odx.test.controller;

import com.odx.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ITestService testService;

    @PostMapping("/v1/longestPalindrome/{input}")
    ResponseEntity<String> longestPalindrome(@PathVariable("input")String input){
       String longestPalindrome = null;
        if(null != input && !input.isEmpty()){
                longestPalindrome = testService.longestPalindrome(input);
                return new ResponseEntity<String>(longestPalindrome, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/v1/longestPalindrome/{input}")
    ResponseEntity<String> longestPalindromeFromDatabase(@PathVariable("input")String input){
        String longestPalindrome = null;
        if(null != input && !input.isEmpty()){
            longestPalindrome = testService.fetchFromDatabasePalindrome(input);
            if(null != longestPalindrome)
            return new ResponseEntity<String>(longestPalindrome, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
