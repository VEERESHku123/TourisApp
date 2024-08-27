package com.example.tourisum_app.model;

public class placeDetails {
    String placeName;
    String about;
    String price;
    Integer imageUrl;
    private Float rating;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public placeDetails(String placeName, String about, String price, Integer imageUrl,float rating) {
        this.placeName = placeName;
        this.about = about;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating=rating;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
