package com.marccaps.racodroid.project.Model;

import android.media.Image;

/**
 * Created by marc on 12/08/2016.
 */
public class User {

    private static String mUsername;
    private static String mPassword;
    private static Image mProfileImage;

    public static Image getProfileImage() {
        return mProfileImage;
    }

    public static void setProfileImage(Image mProfileImage) {
        User.mProfileImage = mProfileImage;
    }

    public static String getUsername() {
        return mUsername;
    }

    public static void setUsername(String mUsername) {
        User.mUsername = mUsername;
    }

    public static String getPassword() {
        return mPassword;
    }

    public static void setPassword(String mPassword) {
        User.mPassword = mPassword;
    }
}
