package com.example.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by da7th on 7/13/2016.
 */
public class TourCardAdapter extends ArrayAdapter<TourCard> {

    private int mColorResourceId;

    public TourCardAdapter(Context context, ArrayList<TourCard> tourCards, int colorResourceId) {
        super(context, 0, tourCards);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tour_card_list_item, parent, false);
        }

        TourCard currentTourCard = getItem(position);

        TextView tourCardTextView = (TextView) listItemView.findViewById(R.id.tour_card_text);

        tourCardTextView.setText(currentTourCard.getCardInfo());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.tour_card_image);

        if (currentTourCard.hasImage()) {
            imageView.setImageResource(currentTourCard.getCardImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
/**
 View tourCardContainer = listItemView.findViewById(R.id.tour_card_container);
 int color = ContextCompat.getColor(getContext(), mColorResourceId);
 tourCardContainer.setBackgroundColor(color);
 **/
        return listItemView;
    }

}
