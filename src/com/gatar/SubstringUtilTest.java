package com.gatar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringUtilTest {
    
    //asterisk tests
    @Test
    void asteriskSingleMiddleLetter() {
        String s1 = "sentence";
        String s2 = "sente*ce";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void asteriskSingleMiddleLetterIncorrect() {
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

    @Test
    void escapedAndStandardAsteriskMultiple() {
        String s1 = "asterisk*he*re";
        String s2 = "t***sk\\*he\\*r*e*";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    //non-asterisk tests
    @Test
    void nullBothStrings() {
        String s1 = null;
        String s2 = null;
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void nullFirstStrings() {
        String s1 = null;
        String s2 = "test";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void nullSecondStrings() {
        String s1 = "test";
        String s2 = null;
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void emptyBothStrings() {
        String s1 = "";
        String s2 = "";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void emptyFirstString() {
        String s1 = "";
        String s2 = "test";
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
    void longerOccurOfSingeSign_secondOccurrenceCorrect() {
        String s1 = "teeeeesteeeeeeeeeeeeeeeet";
        String s2 = "eeeeeeee";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void longerOccurOfSingeSign_secondOccurrence_MissingSign() {
        String s1 = "teeeeesteeeeeeeeeeeeeeeet";
        String s2 = "etee";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void prefix() {
        String s1 = "test";
        String s2 = "tes";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void suffix() {
        String s1 = "test";
        String s2 = "est";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void singleLetter() {
        String s1 = "t";
        String s2 = "t";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void singleLetterIncorrect() {
        String s1 = "t";
        String s2 = "q";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void singleLetterPrefix() {
        String s1 = "testing";
        String s2 = "t";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void singleLetterSuffix() {
        String s1 = "testing";
        String s2 = "g";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void singleLetterInside() {
        String s1 = "testing";
        String s2 = "s";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void differentStrings() {
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

    @Test
    void blankCharacters() {
        String s1 = "dw#  \tq\n\r#";
        String s2 = " \tq\n\r";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void blankCharactersIncorrect() {
        String s1 = "dw#  \tq\n\r#";
        String s2 = " \tq\r";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void unicodeCharacters() {
        String s1 = "თავისუფალი ენციკლოპედი";
        String s2 = "იკლო";
        assertTrue(SubstringUtil.isSubstring(s1, s2));
    }

    @Test
    void unicodeCharactersIncorrect() {
        String s1 = "თავისუფალი ენციკლოპედი";
        String s2 = "იკო";
        assertFalse(SubstringUtil.isSubstring(s1, s2));
    }
}