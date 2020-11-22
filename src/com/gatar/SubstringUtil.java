package com.gatar;

import java.util.*;

public class SubstringUtil {

    private static final char WILDCARD_CHAR = '*';

    private SubstringUtil() {
    }

    /**
     * Check if String s2 is substring of String s1. Asterisk '*' is a wildcard
     * (match zero or more characters) if not escaped '\*'.
     * @param first String to be matched by s2
     * @param second String to match in s1
     * @return true if s2 is substring of s1
     */
    public static boolean isSubstring(String first, String second) {
        boolean result = true;

        if (isAnyEmpty(first, second)) {
            return false;
        }

        if (!isAnyEmpty(first) && containsOnlyAsterisks(second)) {
            return true;
        }

        List<String> elements = splitToFragments(second);
        int firstStringPointer = 0;

        for (String element : elements) {
            boolean fragmentResult = false;
            List<Integer> firstSignPositions = signOccurrences(first, element.charAt(0), firstStringPointer);

            for (int position : firstSignPositions) {
                for (int elementIndex = 0; elementIndex < element.length(); elementIndex++) {
                    int firstIndex = elementIndex + position;
                    if (isIndexOutOfStringLength(first, firstIndex)
                            || first.charAt(firstIndex) != element.charAt(elementIndex)){
                        break;
                    }
                    if (isLastIndex(element, elementIndex)) {
                        fragmentResult = true;
                        firstStringPointer = firstIndex;
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

    private static boolean isAnyEmpty(String...strings) {
        for (String s : strings) {
            if (Objects.isNull(s) || s.length() == 0) return true;
        }
        return false;
    }

    private static boolean containsOnlyAsterisks(String s) {
        return s.chars().filter(SubstringUtil::isAsterisk).count() == s.length();
    }

    private static List<String> splitToFragments(String string) {
        List<String> result = new LinkedList<>();
        char[] array = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            char currentSign = array[i];
            if(isEscapedAsterisk(array, i)) {
                sb.append(WILDCARD_CHAR);
                i++;
            } else if (isAsterisk(currentSign)){
                if (sb.length() != 0) {
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(currentSign);
            }
        }

        if (sb.length() != 0) {
            result.add(sb.toString());
        }
        return result;
    }

    private static boolean isAsterisk(int sign) {
        return sign == WILDCARD_CHAR;
    }

    private static boolean isEscapedAsterisk(char[] array, int index) {
        return array.length > index + 1 && array[index] == '\\' && array[index+1] == WILDCARD_CHAR;
    }

    private static List<Integer> signOccurrences(String string, char c, int startingPosition) {
        List<Integer> result = new ArrayList<>();
        for (int i = startingPosition; i < string.length(); i++) {
            if(c == string.charAt(i)) result.add(i);
        }
        return result;
    }

    private static boolean isIndexOutOfStringLength(String s, int index) {
        return s.length() - 1 < index;
    }

    private static boolean isLastIndex(String s, int index) {
        return index == s.length() - 1;
    }
}
