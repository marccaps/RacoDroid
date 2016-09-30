package com.marccaps.racodroid.project.Connection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceActivity;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import com.marccaps.racodroid.project.Utils.FeedUtils;
import com.marccaps.racodroid.project.Utils.PreferenceUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.security.auth.callback.Callback;


/**
 * Created by marc on 12/08/2016.
 */
public class LoginConnectionClass extends Activity {

    private static final String TAG = LoginConnectionClass.class.getSimpleName();

    public static boolean checkUser(Context context, String username, String password) {
        try {
            String url = AndroidUtils.HTML_INITKEYS + "&loginDirecte=true" +
                    "&username=" + username + "&password=" + password;
            String response = FeedUtils.getURLOutput(url, "UTF-8");
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonObjectNames = jsonObject.names();
            for (int i = 0; i < jsonObjectNames.length(); i++) {
                PreferenceUtil.setPreference(context, jsonObjectNames.getString(i),
                        jsonObject.getString(jsonObjectNames.getString(i)));
            }
            return true;
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] getUserCredentials(Context context) {
        String[] credentials;
        credentials = new String[]{
                PreferenceUtil.getPreference(context, PreferenceUtil.PROPERTY_LOGIN_USER, null),
                PreferenceUtil.getPreference(context, PreferenceUtil.PROPERTY_LOGIN_PASS, null)
        };
        if(credentials[0] == null || credentials[1] == null ){
            return null;
        }
        else return credentials;
    }

}
