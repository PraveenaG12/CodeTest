package com.odx.test.service;

import com.odx.test.entity.PalindromeTrack;
import com.odx.test.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private ITestRepository testRepository;
    @Override
    public String longestPalindrome(String input) {
       String longestPalindrome = findLongestPalindrome(input);
        PalindromeTrack palindromeTrack = new PalindromeTrack();
        palindromeTrack.setInput(input);
        palindromeTrack.setLongestPalindrome(longestPalindrome);
        testRepository.save(palindromeTrack);
        return longestPalindrome;
    }

    @Override
    public String fetchFromDatabasePalindrome(String input) {
       List<PalindromeTrack> palindromeTrack=testRepository.findByInput(input);
       if(null != palindromeTrack && !palindromeTrack.isEmpty())
       {
           return palindromeTrack.get(0).getLongestPalindrome();
       }
       return null;
    }

    private String findLongestPalindrome(String input){
       int maxLength=1;
        int start=0;
        int low,high;
        for(int i=1;i<input.length();++i) {
            //EVENa
            low = i - 1;
            high = i;
            while (low >= 0 && high < input.length() &&
                    input.charAt(low) == input.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            //ODD case
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < input.length() &&
                    input.charAt(low) == input.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
            return input.substring(start,start+maxLength);


    }
}
