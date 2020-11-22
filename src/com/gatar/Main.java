package com.gatar;

import java.util.Scanner;

public class Main {

    private static final String RESULT_MESSAGE = "String second is substring of string first: ";

    public static void main(String[] args) {
        String stringOne;
        String stringTwo;

        if (args.length > 1) {
            stringOne = args[0];
            stringTwo = args[1];
        } else {
            stringOne = readLine("Please type first string\n");
            stringTwo = readLine("Please type second string\n");
        }

        System.out.println(RESULT_MESSAGE + SubstringUtil.isSubstring(stringOne, stringTwo));
    }

    private static String readLine(String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }

}
