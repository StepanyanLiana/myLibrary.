package com.example.myLibrary.util;

import java.util.regex.Pattern;

public final class EmailUtil {
    private EmailUtil(){}
    private final static String EMAIL_REGEX = "^(.+)@(\\S+)$";
public static boolean patternMatches(String emailAddress) {
    return Pattern.compile(EMAIL_REGEX)
            .matcher(emailAddress)
                    .matches();
}
}
