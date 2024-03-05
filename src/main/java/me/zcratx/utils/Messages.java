package me.zcratx.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private static ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");

    public static String getMessage(String message) {
        return bundle.getString(message);
    }

    public static void loadLanguage(Locale locale) {
        bundle = ResourceBundle.getBundle("lang/lang", locale);
    }

    public static  String isCorrect() {
        return "(" + getMessage("yes") + "|" + getMessage("no") + ")";
    }

}
