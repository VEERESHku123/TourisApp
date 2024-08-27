package com.example.tourisum_app.model;

public class hotelData {
    String hotelName;
    String hotelPlace;
    String price;
    Integer imageUrl;
    private Float rating;

    public hotelData(String hotelName ,String hotelPlace,String price,Integer imageUrl,float rating){
        this.hotelName=hotelName;
        this.hotelPlace=hotelPlace;
        this.price=price;
        this.imageUrl=imageUrl;
        this.rating=rating;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) { this.hotelName=hotelName;}

    public String getHotelPlace() {
        return hotelPlace;
    }

    public void setHotelPlace(String hotelPlace) { this.hotelPlace=hotelPlace;}

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {  this.price=price;}

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }





}
