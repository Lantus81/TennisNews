package com.akristic.www.tennisnews;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        // title
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.news_title);
        nameTextView.setText(currentNews.getTitle());

        // section
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.news_section);
        sectionTextView.setText(currentNews.getSection());

        //set text under title
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.news_description);
        descriptionTextView.setText(currentNews.getDescription());

        // set date
        TextView dateTimeTextView = (TextView) listItemView.findViewById(R.id.news_date_time);
        String dateTime = currentNews.getDateTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd' at 'HH:mm");
        try {
            Date d = simpleDateFormat.parse(dateTime);
            dateTimeTextView.setText(newDateFormat.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //set image
        WebView webView = (WebView) listItemView.findViewById(R.id.news_image);
        // set webView to fit for image size

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        //added because of bug when webview launches browser when calling loadurl
        webView.setWebViewClient(new WebViewClient());
        // put image in
        webView.loadUrl(currentNews.getImageUrl());

        return listItemView;
    }

}
