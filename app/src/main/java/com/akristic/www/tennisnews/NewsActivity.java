package com.akristic.www.tennisnews;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        String url = this.getIntent().getData().toString();
        WebView newsWebView = (WebView) findViewById(R.id.news_web_view);
        newsWebView.loadUrl(url);
    }
}
