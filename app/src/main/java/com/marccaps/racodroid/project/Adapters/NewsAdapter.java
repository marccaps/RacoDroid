package com.marccaps.racodroid.project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.marccaps.racodroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by marc on 12/09/2016.
 */
public class NewsAdapter extends ArrayAdapter<RssItem> {
    private final Context mContext;
    private final List<RssItem> mNews;

    public NewsAdapter(Context context, List<RssItem> news) {
        super(context, R.layout.news_item, news);
        this.mContext = context;
        this.mNews = news;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.news_item, parent, false);
        TextView titleNews = (TextView) rowView.findViewById(R.id.title_news);
        TextView dateNews = (TextView) rowView.findViewById(R.id.date_news);
        ImageView imageNews = (ImageView) rowView.findViewById(R.id.image_news);

        titleNews.setText(mNews.get(position).getTitle());
        dateNews.setText(mNews.get(position).getPubDate());
        Picasso.with(mContext).load(mNews.get(position).getImageUrl()).into(imageNews);

        return rowView;
    }
}