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
public class FactsFragment extends Fragment {

    public FactsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_card_list, container, false);

        final ArrayList<TourCard> tourCards = new ArrayList<TourCard>();
        tourCards.add(new TourCard("The flag of Jordan", "https://en.wikipedia.org/wiki/Flag_of_Jordan", R.drawable.flag_of_jordan));
        tourCards.add(new TourCard("Capital: Amman", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Gov: constitutional monarchy", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Currency: JOD", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Population: 8,117,564", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Total Area: 34,495 sq.miles", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Wakalat Street", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Location: Middle East", "http://www.countryreports.org/country/Jordan.htm"));
        tourCards.add(new TourCard("Official Language: Arabic", "http://www.countryreports.org/country/Jordan.htm"));


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

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.countryreports.org/country/Jordan.htm"));
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
