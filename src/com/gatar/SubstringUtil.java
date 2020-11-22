package com.gatar;

import java.util.*;

public class SubstringUtil {

    private SubstringUtil() {
    }

    /**
     * Check if String s2 is substring of String s1. Asterisk '*' is a wildcard
     * (match zero or more characters) if not escaped '\*'.
     * @param s1 String to be matched by s2
     * @param s2 String to match in s1
     * @return true if s2 is substring of s1
     */
    public static boolean isSubstring(String s1, String s2) {
        boolean result = true;

        if (isEmpty(s1) || isEmpty(s2)) {
            return false;
        }

        if (!isEmpty(s1) && isOnlyAsterisk(s2)) {
            return true;
        }

        List<String> elements = splitToFragments(s2);
        int pointer = 0;

        for (String element : elements) {
            boolean fragmentResult = false;
            char[] s2char = element.toCharArray();
            List<Integer> firstSignPositions = signOccurrences(s1, s2char[0], pointer);

            for (int position : firstSignPositions) {
                for (int c2 = 0; c2 < s2char.length; c2++) {
                    if (s1.length() - 1 < (c2 + position) || s1.charAt(c2 + position) != s2char[c2]) break;
                    if (c2 == s2char.length - 1) {
                        fragmentResult = true;
                        pointer = c2 + position;
                    }
                }
                if (fragmentResult) break;
            }
            if (!fragmentResult) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static List<Integer> signOccurrences(String s, char c, int startingPosition) {
        List<Integer> result = new ArrayList<>();
        for (int c1 = startingPosition; c1 < s.length(); c1++) {
            if(c == s.charAt(c1)) result.add(c1);
        }
        return result;
    }

    /**
     * Strictly check (no wildcards allowed) if String s2 is substring of String s1.
     * @param s1 String to be matched by s2
     * @param s2 String to match in s1
     * @return true if s2 is substring of s1
     */
    public static boolean isStrictSubstring(String s1, String s2) {
        throw new UnsupportedOperationException();
    }

    private static boolean isEmpty(String s) {
        return Objects.isNull(s) || s.length() == 0;
    }

    private static boolean isOnlyAsterisk(String s) {
        return s.chars().filter(ch -> ch != '*').count() == 0;
    }

    private static boolean isAsterisk(char sign) {
        return sign == '*';
    }

    private static boolean isEscapedAsterisk(char[] array, int index) {
        return array.length > index + 1 && array[index] == '\\' && array[index+1] == '*';
    }

    private static List<String> splitToFragments(String string) {
        List<String> result = new LinkedList<>();
        char[] array = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if(isEscapedAsterisk(array, i)) {
                sb.append('*');
                i++;
            } else if (isAsterisk(array[i])){
                if (sb.length() != 0) {
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(array[i]);
            }
        }

        if (sb.length() != 0) {
            result.add(sb.toString());
        }
        return result;
    }
}
