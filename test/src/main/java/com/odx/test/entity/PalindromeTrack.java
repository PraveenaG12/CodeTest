package com.odx.test.entity;

import javax.persistence.*;

@Entity
@Table(name="palindrometrack")
public class PalindromeTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="input")
    private String input;
    @Column(name="longestPalindrome")
    private String longestPalindrome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getLongestPalindrome() {
        return longestPalindrome;
    }

    public void setLongestPalindrome(String longestPalindrome) {
        this.longestPalindrome = longestPalindrome;
    }
}
