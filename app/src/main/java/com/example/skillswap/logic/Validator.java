package com.example.skillswap.logic;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isEmailCorrect(String email){

        return Pattern.matches(String.valueOf(Patterns.EMAIL_ADDRESS), email);

    }

    public static boolean isPasswordCorrect(String password){

        return password.length() > 8;

    }

    public static boolean isPasswordMatched(String password, String confirmPassword){

        return password.matches(confirmPassword);

    }

    public static boolean isFieldEmpty(String content){

        return content.isEmpty();

    }

}
