package com.example.android.tourguideapp;

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
public class MainSitesFragment extends Fragment {

    public MainSitesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_card_list, container, false);

        final ArrayList<TourCard> tourCards = new ArrayList<TourCard>();
        tourCards.add(new TourCard("Amman Citadel", "", ""));
        tourCards.add(new TourCard("King Abdullah I Mosque", "", ""));
        tourCards.add(new TourCard("Roman Theatre", "", ""));
        tourCards.add(new TourCard("Royal Automobile Museum", "", ""));
        tourCards.add(new TourCard("Jordan Archaeological Museum", "", ""));
        tourCards.add(new TourCard("Wakalat Street", "", ""));
        tourCards.add(new TourCard("Mango House", "", ""));
        tourCards.add(new TourCard("Intercontinental Jordan Hotel", "", ""));

        TourCardAdapter tourCardAdapter = new TourCardAdapter(getActivity(), tourCards, R.color.category_Main_Sites);

        ListView cardListView = (ListView) rootView.findViewById(R.id.TourCardList);

        cardListView.setAdapter(tourCardAdapter);

        cardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourCard tourCard = tourCards.get(position);

                //here goes the intent for a browser
            }
        });

        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
    }

}