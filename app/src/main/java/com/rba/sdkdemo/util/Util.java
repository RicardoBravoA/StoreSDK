package com.rba.sdkdemo.util;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class Util {

    public static boolean validEmailPattern(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static boolean validEmail(String email){
        return validEmailPattern(email.trim());
    }

    public static boolean validPassword(String password) {
        return password.length()>5;
    }

    public static boolean validName(String name) {
        return name.length()>2;
    }

}
