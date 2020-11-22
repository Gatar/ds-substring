package com.gatar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringUtilTest {
    
    //asterisk tests
    @Test
    void asteriskSingleLetter() {
        String s1 = "sentence";
        String s2 = "sente*ce";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void asteriskSingleLetterIncorrect() {
        String s1 = "sentence";
        String s2 = "senten*q";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void asteriskFirstLetter() {
        String s1 = "sentence";
        String s2 = "*ce";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void asteriskLastLetter() {
        String s1 = "sentence";
        String s2 = "sente*";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void asteriskOnly() {
        String s1 = "sentence";
        String s2 = "*";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void asteriskOnlyMultiple() {
        String s1 = "sentence";
        String s2 = "*************";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void multipleAsterisk() {
        String s1 = "longer sentence";
        String s2 = "lon* se*e";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void multipleAsteriskIncorrect() {
        String s1 = "longer sentence";
        String s2 = "lon*_se*e";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void escapedAsteriskInTheMiddle() {
        String s1 = "asterisk*here";
        String s2 = "sk\\*here";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void escapedAsteriskFirst() {
        String s1 = "*asteriskhere";
        String s2 = "\\*ast";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void escapedAsteriskLast() {
        String s1 = "asteriskhere*";
        String s2 = "skhere\\*";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void escapedAsteriskThreeInTheRow() {
        String s1 = "asterisk***here";
        String s2 = "sk\\*\\*\\*here";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void escapedAsteriskMultiple() {
        String s1 = "asterisk*he*re";
        String s2 = "sk\\*he\\*re";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    //non-asterisk tests
    @Test
    void emptyBothStrings() {
        String s1 = "";
        String s2 = "";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void emptySecondString() {
        String s1 = "test";
        String s2 = "";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void twoEqualStrings() {
        String s1 = "test";
        String s2 = "test";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void longerOccurOfSingeSign() {
        String s1 = "teeeeest";
        String s2 = "eee";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void longerOccurOfSingeSign_tooLong() {
        String s1 = "teeeeest";
        String s2 = "eeeeeeeeee";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void longerOccurOfSingeSign_secondOccurence() {
        String s1 = "teeeeesteeeeeeeeeeeeeeeet";
        String s2 = "eeeeeeee";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void longerOccurOfSingeSign_secondOccurence_MissingSign() {
        String s1 = "teeeeesteeeeeeeeeeeeeeeet";
        String s2 = "etee";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void substringThreeSignsPrefix() {
        String s1 = "test";
        String s2 = "tes";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void substringThreeSignsSuffix() {
        String s1 = "test";
        String s2 = "est";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void singleLetter() {
        String s1 = "test";
        String s2 = "s";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void notSubstringStrings() {
        String s1 = "test";
        String s2 = "opal";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void secondStringLongerThanFirst() {
        String s1 = "test";
        String s2 = "testtest";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void specialCharacters() {
        String s1 = "#$%^&*%$@#";
        String s2 = "$@";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }
}