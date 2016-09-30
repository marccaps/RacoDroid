package com.marccaps.racodroid.project.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.marccaps.racodroid.R;
import com.marccaps.racodroid.project.Connection.AndroidUtils;
import com.marccaps.racodroid.project.Utils.PreferenceUtil;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Created by marc on 17/08/2016.
 */
public class EmailFragment extends Fragment {

    List<Message> mInbox = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.emailayout, container, false);

        readEmail();

        return rootView;
    }


    public void readEmail() {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.imap.port", "993");


        try {
            Session session = Session.getDefaultInstance(properties, null);
            Store store = session.getStore("imaps");
            store.connect("correu.fib.upc.edu",
                    PreferenceUtil.getPreference(getActivity(), PreferenceUtil.PROPERTY_LOGIN_USER, "username"),
                    PreferenceUtil.getPreference(getActivity(), PreferenceUtil.PROPERTY_LOGIN_PASS, "password"));
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            for (int i = 1; i < inbox.getDeletedMessageCount(); ++i) {
                mInbox.add(inbox.getMessage(i));
            }
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

}
