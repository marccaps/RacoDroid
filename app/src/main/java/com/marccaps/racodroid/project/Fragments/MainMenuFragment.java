package com.marccaps.racodroid.project.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.marccaps.racodroid.R;

/**
 * Created by marc on 16/08/2016.
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener{

    RelativeLayout mMailSection;
    RelativeLayout mNewsSection;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.mainmenulayout, container, false);

        findChild(rootView);

        mMailSection.setOnClickListener(this);
        mNewsSection.setOnClickListener(this);

        return rootView;

    }

    private void findChild(View rootView) {
        mMailSection = (RelativeLayout) rootView.findViewById(R.id.mail_section);
        mNewsSection = (RelativeLayout) rootView.findViewById(R.id.news_section);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.mail_section:
                EmailFragment emailFragment = new EmailFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.linear_layout_main, emailFragment)
                        .commit();
                break;

            case R.id.news_section:
                NewsFragment newsFragment = new NewsFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.linear_layout_main, newsFragment)
                        .commit();

            default:
                break;
        }
    }
}
