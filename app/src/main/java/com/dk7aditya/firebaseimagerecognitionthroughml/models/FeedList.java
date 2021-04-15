package com.dk7aditya.firebaseimagerecognitionthroughml.models;

public class FeedList {
    private String imageNewsUrl;
    private String imageNewsTitle;
    private String imageNewsDescription;

    public FeedList(String imageNewsUrl, String imageNewsTitle, String imageNewsDescription) {
        this.imageNewsUrl = imageNewsUrl;
        this.imageNewsTitle = imageNewsTitle;
        this.imageNewsDescription = imageNewsDescription;
    }
    public FeedList(){

    }

    public String getImageNewsUrl() {
        return imageNewsUrl;
    }

    public void setImageNewsUrl(String imageNewsUrl) {
        this.imageNewsUrl = imageNewsUrl;
    }

    public String getImageNewsTitle() {
        return imageNewsTitle;
    }

    public void setImageNewsTitle(String imageNewsTitle) {
        this.imageNewsTitle = imageNewsTitle;
    }

    public String getImageNewsDescription() {
        return imageNewsDescription;
    }

    public void setImageNewsDescription(String imageNewsDescription) {
        this.imageNewsDescription = imageNewsDescription;
    }

    @Override
    public String toString() {
        return "FeedList{" +
                "imageNewsUrl='" + imageNewsUrl + '\'' +
                ", imageNewsTitle='" + imageNewsTitle + '\'' +
                ", imageNewsDescription='" + imageNewsDescription + '\'' +
                '}';
    }
}
