package com.akristic.www.tennisnews;


import static android.R.attr.description;

public class News {
    private String mTitle;
    private String mUrl;
    private String mImageUrl;
    private String mSection;
    private String mDescription;
    private String mDateTime;

    public News(String title, String url, String imageUrl, String section, String description, String dateTime) {
        mTitle = title;
        mUrl = url;
        mImageUrl = imageUrl;
        mSection = section;
        mDescription = description;
        mDateTime = dateTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
    public String getSection() {
        return mSection;
    }
    public  String getDescription (){
        return mDescription;
    }
    public String getDateTime (){
        return mDateTime;
    }
}

