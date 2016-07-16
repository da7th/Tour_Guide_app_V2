package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by da7th on 7/13/2016.
 */
public class HistoricalFragment extends Fragment {

    public HistoricalFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_card_list, container, false);

        final ArrayList<TourCard> tourCards = new ArrayList<TourCard>();
        tourCards.add(new TourCard(getString(R.string.petra), getString(R.string.petra_link), R.drawable.petra));
        tourCards.add(new TourCard(getString(R.string.mount_nebo), getString(R.string.mount_nebo_link), R.drawable.mount_nebo));
        tourCards.add(new TourCard(getString(R.string.madaba_map), getString(R.string.madaba_map_link), R.drawable.madaba_map));
        tourCards.add(new TourCard(getString(R.string.royal_auto_museum), getString(R.string.royal_auto_museum_link), R.drawable.royal_automobile_museum));
        tourCards.add(new TourCard(getString(R.string.qasr_amra), getString(R.string.qasr_amra_link), R.drawable.qasr_amra));
        tourCards.add(new TourCard(getString(R.string.amman_citadel), getString(R.string.amman_citadel_link), R.drawable.amman_citadel));
        tourCards.add(new TourCard(getString(R.string.roman_theatre), getString(R.string.roman_theatre_link), R.drawable.roman_theatre));
        tourCards.add(new TourCard(getString(R.string.montreal), getString(R.string.montreal_link), R.drawable.montreal));
        tourCards.add(new TourCard(getString(R.string.ajloun_castle), getString(R.string.ajloun_castle_link), R.drawable.ajloun_castle));
        tourCards.add(new TourCard(getString(R.string.azraq_wetland_reserve), getString(R.string.azraq_wetland_reserve_link), R.drawable.azraq_wetland_reserve));

        TourCardAdapter tourCardAdapter = new TourCardAdapter(getActivity(), tourCards, R.color.colorPrimary);

        ListView cardListView = (ListView) rootView.findViewById(R.id.TourCardList);

        cardListView.setAdapter(tourCardAdapter);

        cardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourCard tourCard = tourCards.get(position);

                //here goes the intent for a browser
                String url = tourCard.getCardInfoLink();

                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
