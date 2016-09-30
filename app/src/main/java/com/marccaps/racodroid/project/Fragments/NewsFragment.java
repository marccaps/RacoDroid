package com.marccaps.racodroid.project.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.marccaps.racodroid.R;
import com.marccaps.racodroid.project.Adapters.NewsAdapter;
import com.marccaps.racodroid.project.Connection.AndroidUtils;

import java.util.List;

/**
 * Created by marc on 30/08/2016.
 */
public class NewsFragment extends Fragment implements OnRssLoadListener {

    ListView mNewsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.newslayout, container, false);

        mNewsList = (ListView) rootView.findViewById(R.id.news_list);

        loadFeeds();

        return rootView;
    }

    private void loadFeeds() {
        String[] urlArr = {AndroidUtils.URL_NEWS_RSS};
        new RssReader(getActivity())
                .showDialog(true)
                .urls(urlArr)
                .parse(this);
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {
        ArrayAdapter arrayAdapter = new NewsAdapter(getActivity(),rssItems);
        mNewsList.setAdapter(arrayAdapter);
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(getActivity(), "Error: " + message, Toast.LENGTH_SHORT).show();

    }
}
