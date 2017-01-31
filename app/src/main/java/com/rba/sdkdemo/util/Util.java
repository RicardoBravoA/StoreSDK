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
        if(validEmailPattern(email.trim())){
            return true;
        }
        return false;
    }

    public static boolean validPassword(String password) {
        if(password.length()>5){
            return true;
        }
        return false;
    }

}
