package com.example.android.tourguideapp;

/**
 * Created by da7th on 7/13/2016.
 */
public class TourCard {

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mCardImageResourceId = NO_IMAGE_PROVIDED;
    private String mCardInfoLink;

    private String mCardInfo;


    public TourCard(String cardInfo, String cardInfoLink, int cardImageResourceId) {
        cardInfo = mCardInfo;
        cardInfoLink = mCardInfoLink;
        cardImageResourceId = mCardImageResourceId;
    }

    public TourCard(String cardInfo, String cardInfoLink) {
        cardInfo = mCardInfo;
        cardInfoLink = mCardInfoLink;
    }

    public String getCardInfo() {
        return mCardInfo;
    }

    public String getCardInfoLink() {
        return mCardInfoLink;
    }

    public int getCardImageResourceId() {
        return mCardImageResourceId;
    }

    public boolean hasImage() {
        return mCardImageResourceId != NO_IMAGE_PROVIDED;
    }


}
