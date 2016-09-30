package com.marccaps.racodroid.project.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by marc on 13/08/2016.
 */
public class PreferenceUtil {

    public static final String PROPERTY_LOGIN_USER = "loginUser";
    public static final String PROPERTY_LOGIN_PASS = "loginPass";
    public static final String PROPERTY_USER_NAME = "userName";
    public static final String PROPERTY_USER_MAIL = "userMail";
    public static final String PROPERTY_LAST_FRAGMENT = "lastFragment";

    public static String getPreference(Context context, String key, String defaultValue) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString(key, defaultValue);
    }

    public static void setPreference(Context context, String preference, String value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(preference, value);
        editor.apply();
    }

    public static int getPreference(Context context, String key, int defaultValue) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getInt(key, defaultValue);
    }

    public static void setPreference(Context context, String preference, int value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(preference, value);
        editor.apply();
    }

    public static void removePreference(Context context, String preference) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(preference);
        editor.apply();
    }
}
