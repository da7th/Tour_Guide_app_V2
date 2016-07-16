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
public class ArchaeoFragment extends Fragment {

    public ArchaeoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_card_list, container, false);

        final ArrayList<TourCard> tourCards = new ArrayList<TourCard>();
        tourCards.add(new TourCard("Jordan Archaeological Museum", "http://culture.gov.jo/new/%D8%A7%D9%84%D9%85%D8%AA%D8%A7%D8%AD%D9%81/6952-%D9%85%D8%AA%D8%AD%D9%81-%D8%A7%D9%84%D8%A2%D8%AB%D8%A7%D8%B1-%D8%A7%D9%84%D8%A3%D8%B1%D8%AF%D9%86%D9%8A", R.drawable.jordan_archaeological_museum));
        tourCards.add(new TourCard("Roman Theatre", "https://en.wikipedia.org/wiki/Roman_theater_(Amman)", R.drawable.roman_theatre));
        tourCards.add(new TourCard("Roman Philadelphia", "https://en.wikipedia.org/wiki/Ala%C5%9Fehir", R.drawable.roman_philadelphia));
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
