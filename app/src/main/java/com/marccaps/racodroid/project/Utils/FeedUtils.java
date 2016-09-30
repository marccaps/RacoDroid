package com.marccaps.racodroid.project.Utils;

import android.content.Context;
import android.text.Html;

import com.marccaps.racodroid.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by marc on 13/08/2016.
 */
public class FeedUtils {

    public static String getURLOutput(final String url, final String encoding) {
        final String[] response = {null};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String tempUrl = url;
                    HttpURLConnection connection;
                    CookieHandler.setDefault(new CookieManager());
                    do {
                        connection = (HttpURLConnection) new URL(tempUrl).openConnection();
                        connection.setInstanceFollowRedirects(false);
                        connection.setUseCaches(false);
                        connection.setRequestMethod("GET");
                        connection.connect();
                        int responseCode = connection.getResponseCode();
                        if (responseCode >= 300 && responseCode < 400) {
                            String redirectedUrl = connection.getHeaderField("Location");
                            if (redirectedUrl == null) break;
                            tempUrl = redirectedUrl;
                        } else break;
                    } while (connection.getResponseCode() != HttpURLConnection.HTTP_OK);
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream(), Charset.forName(encoding)));
                    response[0] = readAll(reader);
                    connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
            return response[0];
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
